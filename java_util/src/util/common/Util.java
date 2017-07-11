package util.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Util使用类(测试过的)
 * 
 * @author chen
 *
 */
public class Util {

	/**
	 * 切割字符串成ArrayList<br>
	 * 如果遇到 . | ^ * : <br>
	 * 方法会自动加上\\
	 * 
	 * @param content
	 * @param regex
	 */
	public static List<String> splitToArray(String content, String regex) {
		List<String> list = new ArrayList<String>();
		CharSequence cs = regex;
		if (content.contains(cs)) {
			// . | ^ * :
			if (regex.equals(".") || regex.equals("|") || regex.equals("^") || regex.equals("*") || regex.equals(":")) {
				regex = "\\" + regex;
			}
			String[] str_ = content.split(regex);
			for (String string : str_) {
				list.add(string);
			}
		} else {
			list.add(content);
		}
		return list;
	}

	/**
	 * double类型保留2位小数并进行四舍五入
	 * 
	 * @return
	 */
	public static double formatTo45(double d) {
		return Double.parseDouble(String.format("%.2f", d));
	}

}
