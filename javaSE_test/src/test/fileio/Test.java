package test.fileio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 行读文件
 * 
 * @author chen
 *
 */
public class Test {

	static String path = "/Users/chen/Downloads/testDMP.csv";
	static String path2 = "/Users/chen/Downloads/test2DMP.csv";

	public static void main(String[] args) {

		try {
			File file = new File(path);
			File file2 = new File(path2);
			InputStreamReader read = new InputStreamReader(new FileInputStream(file));// 考虑到编码格式
			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(file2));
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt = null;
			while ((lineTxt = bufferedReader.readLine()) != null) {
				// 每行处理
				// 按照,分隔
				String str1[] = lineTxt.split(",");
				int length = str1.length;
				// 拼接
				StringBuffer sb = new StringBuffer();
				try {
					for (int i = 0; i < length - 1; i++) {
						//
						String str = str1[i];
						if (i == 2) {
							String str_1 = str.substring(0, str.length() - 2);
							sb.append(str_1 + ",");
							//
							String str_2 = str.substring(0, str.length() - 6);
							sb.append(str_2 + ",");

						} else {
							sb.append(str + ",");
						}
					}
				} catch (Exception e) {
					continue;
				}
				sb.append(str1[length - 1]);

				out.write(sb.toString() + "\r\n");
				// System.out.println(sb);
			}
			read.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
