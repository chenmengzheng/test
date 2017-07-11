//package test.aio;
//
//import static java.nio.file.StandardOpenOption.READ;
//import java.io.IOException;
//import java.nio.ByteBuffer;
//import java.nio.channels.AsynchronousFileChannel;
//import java.nio.channels.CompletionHandler;
//import java.nio.charset.Charset;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
///**
// * 使用CompletionHandler方式实现aiod 写入
// * 
// * @author chen
// *
// */
//public class AioReadCompletionHandler {
//
//	public static void main(String[] args) throws Exception {
//		Path path = Paths.get("/Users/chen/Documents/123456.txt");
//		AsynchronousFileChannel afc = AsynchronousFileChannel.open(path, READ);
//		ReadHandler handler = new ReadHandler();
//		int fileSize = (int) afc.size();
//		ByteBuffer dataBuffer = ByteBuffer.allocate(fileSize);
//		Attachment attach = new Attachment();
//		attach.asyncChannel = afc;
//		attach.buffer = dataBuffer;
//		attach.path = path;
//		afc.read(dataBuffer, 0, attach, handler);
//		System.out.println("Sleeping for 5  seconds...");
//		Thread.sleep(5000);
//	}
//}
//
//class Attachment {
//	public Path path;
//	public ByteBuffer buffer;
//	public AsynchronousFileChannel asyncChannel;
//}
//
//class ReadHandler implements CompletionHandler<Integer, Attachment> {
//	@Override
//	public void completed(Integer result, Attachment attach) {
//		System.out.format("%s bytes read   from  %s%n", result, attach.path);
//		System.out.format("Read data is:%n");
//		byte[] byteData = attach.buffer.array();
//		Charset cs = Charset.forName("UTF-8");
//		String data = new String(byteData, cs);
//		System.out.println(data);
//		try {
//			// Close the channel
//			attach.asyncChannel.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Override
//	public void failed(Throwable e, Attachment attach) {
//		System.out.format("Read operation  on  %s  file failed." + "The  error is: %s%n", attach.path, e.getMessage());
//		try {
//			// Close the channel
//			attach.asyncChannel.close();
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//	}
//
//}