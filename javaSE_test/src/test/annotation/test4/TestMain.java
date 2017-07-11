package test.annotation.test4;

/**
 * 测试获取annotation中的值
 * 
 * @author chen
 *
 */
public class TestMain {

	public static void main(String[] args) {

		RiskEvent riskEvent = new RiskEvent();

		// 这里的event指的是父类,具体解析的是子类上面的注解RiskEvent
		EventDef eventDef = riskEvent.getClass().getAnnotation(EventDef.class);

		//通过注解中的方法获取RiskEvent的值
		String exchange = eventDef.eventgroup();

		
		//处理注解中值的业务逻辑
		System.out.println(exchange);//Risk_Group

	}

}

