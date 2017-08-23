package util.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * <pre>
 *	用于格式化输出,调试使用
 * </pre>
 * 
 * @author chen mengzheng
 * @version 创建时间：2017年3月14日 上午9:38:57
 */
public class PrintUtil {
	
	/**
	 * 接受List<bean>,bean,map,jsonObject,jsonArray 打印出参，然后可以直接copy到接口文档
	 */
	public static void printOut(Object... results) {

		for (Object object : results) {
			if (object == null) {
				// null
				print(null);
			} else if (object instanceof JSONArray || object instanceof List<?>) {
				// list
				printJsonArray(JSONArray.parseArray(JSON.toJSONString(object)), "", "");
			} else {
				// map
				printJsonObject(JSONObject.parseObject(JSON.toJSONString(object)), "", "");
			}
			println();
			// println("====================>");
		}
	}

	private static void printJsonObject(JSONObject jsonObj, String blank, String firstBlank) {
		println(firstBlank + "{");
		int i = 0;
		for (Entry<String, Object> param : jsonObj.entrySet()) {
			// print key:
			print(blank + "  \"" + param.getKey() + "\":");
			Object value = param.getValue();
			if (value instanceof JSONObject) {
				printJsonObject((JSONObject) value, blank + "  ", "");
			} else if (value instanceof JSONArray) {
				JSONArray array = (JSONArray) value;
				println("[");
				for (int j = 0; j < array.size(); j++) {
					printJsonObject(array.getJSONObject(j), blank + "   ", blank + "   ");
					if (j != array.size() - 1) {
						println(",");
					}
				}
				println();
				print(blank + "  " + "]");
			} else {
				print("\"" + value + "\"");
			}
			i++;
			if (i == jsonObj.entrySet().size()) {
				println();
			} else {
				println(",");
			}
		}
		print(blank + "}");
	}

	private static void printJsonArray(JSONArray jsonArray, String blank, String firstBlank) {
		println(firstBlank + "[");
		for (int i = 0; i < jsonArray.size(); i++) {
			Object object = jsonArray.get(i);
			printJsonObject((JSONObject) object, "   ", "   ");
			if (i < jsonArray.size() - 1) {
				println(",");
			}
		}
		println();
		print(blank + "]");
	}

	private static void print(String str) {
		System.out.print(str);
		// log.info(str);

	}

	private static void println(String str) {
		System.out.println(str);
		// log.info(str);
		// log.info("\n");
	}

	private static void println() {
		System.out.println();
		// log.info("\n");
	}
   
	/**
	 * json转化为map
	 * @param jsonStr
	 * @return
	 */
//	public static Map<String, Object> convertJsonStrToMap(String jsonStr) {
//		Map<String, Object> map = JSON.parseObject(jsonStr, new TypeReference<Map<String, Object>>() {});
//		return map;
//	}
	
	/**
	 * 处理异常信息
	 * 
	 * @param e
	 * @return
	 */
	public static String getStackMsg(Exception e) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		return sw.toString();
	}
	
}
