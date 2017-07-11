package test.map;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap是map中最常用的也是最快速的(非线程安全的)
 * 
 * @author chen
 *
 */
public class HashMapTest {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<>();

		map.put("a", "123");
		map.put("b", "456");

		for (String value : map.values()) {

			System.out.println("Value = " + value);

		}

	}

}
