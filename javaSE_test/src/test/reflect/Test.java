package test.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) throws Throwable {

		// 传统方式调用car
		// Car car = new Car();
		// car.setBrand("红旗CA72");
		// car.introduce();

		// 反射的方式
		Car car = initByDefaultConst();
		car.introduce();

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Car initByDefaultConst() throws Throwable {
		// 通过类装载器获取Car类对象
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		//loadClass(String name)中的name必须使用全限定类名
		Class clazz = loader.loadClass("test.reflect.Car");

		// 通过Car的反射类对象获取Car的构造函数对象cons
		Constructor cons = clazz.getDeclaredConstructor((Class[]) null);
		Car car = (Car) cons.newInstance();

		// 通过Car的反射类对象的getMethod（String methodName,Class
		// paramClass）获取属性的Setter方法对象，第一个参数是目标Class的方法名；第二个参数是方法入参的对象类型。
		//
		// 获取方法反射对象后，即可通过invoke（Object obj,Object
		// param）方法调用目标类的方法，该方法的第一个参数是操作的目标类对象实例；第二个参数是目标方法的入参。
		Method setBrand = clazz.getMethod("setBrand", String.class);
		setBrand.invoke(car, "红旗CA72");
		Method setColor = clazz.getMethod("setColor", String.class);
		setColor.invoke(car, "黑色");
		Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
		setMaxSpeed.invoke(car, 200);
		return car;
	}

}
