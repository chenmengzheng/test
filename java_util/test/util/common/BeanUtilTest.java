package util.common;

import org.junit.Test;

import test.model.User;

public class BeanUtilTest {
	
	@Test
	public void beanToMap(){
		User user = new User();
		user.setId(10);
		user.setName("chen");
		user.setEmail("11");
		System.out.println(user);	

		System.out.println(BeanUtil.beanToMap(user));	
	}

}
