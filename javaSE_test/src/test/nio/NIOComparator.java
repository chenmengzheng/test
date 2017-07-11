package test.nio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 对传统 I/O、基于 Byte 的 NIO、基于内存映射的 NIO 三种方式进行了性能上的对比，使用一个有 400
 * 万数据的文件的读、写操作耗时作为评测依据 <br>
 * 100000000个数据
 * 9775 237 <br>
 * 2497 17 <br>
 * 244 21<br>
 * 
 * @author chen
 *
 */
public class NIOComparator {

	public static final int num = 100000000;

	public static final String path = "/Users/chen/Documents/123456789.txt";

	public void IOMethod(String TPATH) {
		long start = System.currentTimeMillis();
		try {
			DataOutputStream dos = new DataOutputStream(
					new BufferedOutputStream(new FileOutputStream(new File(TPATH))));
			for (int i = 0; i < num; i++) {
				dos.writeInt(i);// 写入 4000000 个整数
			}
			if (dos != null) {
				dos.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		start = System.currentTimeMillis();
		try {
			DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(new File(TPATH))));
			for (int i = 0; i < 4000000; i++) {
				dis.readInt();
			}
			if (dis != null) {
				dis.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public void ByteMethod(String TPATH) {
		long start = System.currentTimeMillis();
		try {
			FileOutputStream fout = new FileOutputStream(new File(TPATH));
			FileChannel fc = fout.getChannel();// 得到文件通道
			ByteBuffer byteBuffer = ByteBuffer.allocate(num * 4);// 分配Buffer
			for (int i = 0; i < num; i++) {
				byteBuffer.put(int2byte(i));// 将整数转为数组
			}
			byteBuffer.flip();// 准备写
			fc.write(byteBuffer);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		start = System.currentTimeMillis();
		FileInputStream fin;
		try {
			fin = new FileInputStream(new File(TPATH));
			FileChannel fc = fin.getChannel();// 取得文件通道
			ByteBuffer byteBuffer = ByteBuffer.allocate(4000000 * 4);// 分配Buffer
			fc.read(byteBuffer);// 读取文件数据
			fc.close();
			byteBuffer.flip();// 准备读取数据
			while (byteBuffer.hasRemaining()) {
				byte2int(byteBuffer.get(), byteBuffer.get(), byteBuffer.get(), byteBuffer.get());// 将byte转为整数
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public void mapMethod(String TPATH) {
		long start = System.currentTimeMillis();
		// 将文件直接映射到内存的方法
		try {
			@SuppressWarnings("resource")
			FileChannel fc = new RandomAccessFile(TPATH, "rw").getChannel();
			IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, num * 4).asIntBuffer();
			for (int i = 0; i < num; i++) {
				ib.put(i);
			}
			if (fc != null) {
				fc.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		start = System.currentTimeMillis();
		try {
			FileChannel fc = new FileInputStream(TPATH).getChannel();
			MappedByteBuffer lib = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
			lib.asIntBuffer();
			while (lib.hasRemaining()) {
				lib.get();
			}
			if (fc != null) {
				fc.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public static byte[] int2byte(int res) {
		byte[] targets = new byte[4];
		targets[3] = (byte) (res & 0xff);// 最低位
		targets[2] = (byte) ((res >> 8) & 0xff);// 次低位
		targets[1] = (byte) ((res >> 16) & 0xff);// 次高位
		targets[0] = (byte) ((res >>> 24));// 最高位，无符号右移
		return targets;
	}

	public static int byte2int(byte b1, byte b2, byte b3, byte b4) {
		return ((b1 & 0xff) << 24) | ((b2 & 0xff) << 16) | ((b3 & 0xff) << 8) | (b4 & 0xff);
	}

	public static void main(String[] args) {
		NIOComparator nio = new NIOComparator();
		nio.IOMethod(path);
		nio.ByteMethod(path);
		nio.mapMethod(path);
	}
}