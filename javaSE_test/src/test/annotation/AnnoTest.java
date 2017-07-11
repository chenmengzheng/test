package test.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class AnnoTest {
	public static void main(String[] args) throws ClassNotFoundException {
		// 要使用到反射中的相关内容
		Class c = Class.forName("test.annotation.Anno");
		Method[] method = c.getMethods();
		boolean flag = c.isAnnotationPresent(FirstAnno.class);
		if (flag) {
			FirstAnno first = (FirstAnno) c.getAnnotation(FirstAnno.class);
			System.out.println("First Annotation:" + first.value() + "\n");
		}

		List<Method> list = new ArrayList<Method>();
		for (int i = 0; i < method.length; i++) {
			list.add(method[i]);
		}

		for (Method m : list) {
			SecondAnnotation anno = m.getAnnotation(SecondAnnotation.class);
			if (anno == null)
				continue;

			System.out.println("second annotation's\nname:\t" + anno.name() + "\nurl:\t" + anno.url());
		}

		List<Field> fieldList = new ArrayList<Field>();
		for (Field f : c.getDeclaredFields()) {// 访问所有字段
			Kitto k = f.getAnnotation(Kitto.class);
			System.out.println("----kitto anno: " + k.value());
		}
	}

}
