package test.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 这里的例子是写BIO,jdk1.1中就有的
 * 
 * @author chen
 *
 */
public class BIO {

	public void writeFile() {
		String path = "";
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	//
	public void readFile() {
		String path = "";
		try {
			// 读文件
			File file1 = new File(path);
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new FileReader(file1));
				String tempString = null;
				int line = 1;
				// 一次读一行，读入null时文件结束
				while ((tempString = reader.readLine()) != null) {
					System.out.println("line " + line + ": " + tempString);
					line++;
				}
				reader.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		BIO bio = new BIO();
		bio.writeFile();
		bio.readFile();
	}

}
