package test.aio;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 使用CompletionHandler方式实现aiod 读取
 * 
 * 采用ByteBuffer 1626比nio要快2497.(这个数据不可靠,好像什么数据都没有写进去,不知道什么回事.)
 * 
 * @author chen
 *
 */
public class AioWriteCompletionHandler {

	public static void main(String[] args) throws Exception {
		Path path = Paths.get("/Users/chen/Documents/456.txt");
		// 这里的afc可以给CompletionHandler和Future使用
		AsynchronousFileChannel afc = AsynchronousFileChannel.open(path, WRITE, CREATE);
		WriteHandler handler = new WriteHandler();
		ByteBuffer dataBuffer = getDataBuffer();
		Attachment attach = new Attachment();
		attach.asyncChannel = afc;
		attach.buffer = dataBuffer;
		attach.path = path;
		afc.write(dataBuffer, 0, attach, handler);
		System.out.println("Sleeping for 5  seconds...");
		Thread.sleep(5000);
	}

	/**
	 * 返回要写进文件的数据
	 * 
	 * @return
	 */
	public static ByteBuffer getDataBuffer() {
		String lineSeparator = System.getProperty("line.separator");
		StringBuilder sb = new StringBuilder();
		sb.append("test");
		sb.append(lineSeparator);
		sb.append("test");
		sb.append(lineSeparator);
		String str = sb.toString();
		Charset cs = Charset.forName("UTF-8");
		ByteBuffer bb = ByteBuffer.wrap(str.getBytes(cs));
		return bb;
	}
}

class Attachment {
	public Path path;
	public ByteBuffer buffer;
	public AsynchronousFileChannel asyncChannel;
}

class WriteHandler implements CompletionHandler<Integer, Attachment> {
	@Override
	public void completed(Integer result, Attachment attach) {
		System.out.format("%s bytes written  to  %s%n", result, attach.path.toAbsolutePath());
		try {
			attach.asyncChannel.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void failed(Throwable e, Attachment attach) {
		try {
			attach.asyncChannel.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
