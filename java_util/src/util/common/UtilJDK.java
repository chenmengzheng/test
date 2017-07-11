package util.common;

import java.util.ResourceBundle;

/**
 * 在JDK的基础上进行简单封装
 * 
 * @author chen
 *
 */
public class UtilJDK {

	/**
	 * 帮助分析xxx.properties,注意properties文件要放在类路径.
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public static ResourceBundle Resourece(String name) throws Exception{
		if(null == name && name.equals("")){
			
		}
		ResourceBundle bundle = ResourceBundle.getBundle(name);
		if (bundle == null) {
			throw new IllegalArgumentException("[redis.properties] is not found!");
		}
		return bundle;
	}

}
