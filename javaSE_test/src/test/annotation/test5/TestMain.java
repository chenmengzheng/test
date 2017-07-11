package test.annotation.test5;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import test.annotation.test4.EventDef;

/**
 * 测试如何在知道类名,方法名的情况下,使用注解,将jsonobject=>in
 * 
 * @author chen
 *
 */
public class TestMain {

	public static String class_name = "test.annotation.test5.TestClass";

	public static String method_name = "TestMethod";

	public static void main(String[] args) {
		try {

			Class<?> cls = Class.forName(class_name);

			// 这里查找方法的方式暂时使用for的方式(循环这个类中的所有的方法),之后有更好的方法可以替换
			// Method method = cls.getMethod(method_name,Object.class);

			Method[] methods = cls.getMethods();

			// 目标方法
			Method method = null;

			for (Method method_temp : methods) {
				if (method_temp.getName().equals(method_name)) {
					method = method_temp;
					break;
				}
			}

			Annotation[][] an = method.getParameterAnnotations();

			for (Annotation[] an_i : an) {
				for (Annotation an_j : an_i) {
//					 an_j.
				}
			}

			// method.getAnnotation(EventDef.class);

			System.out.println(an);

			// } catch (NoSuchMethodException e) {
			// e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
