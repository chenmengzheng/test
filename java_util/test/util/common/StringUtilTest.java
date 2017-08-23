package util.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import test.commons.BaseTest;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class StringUtilTest extends BaseTest{
	
	@Test
	public void isNullDefault(){
		print(StringUtil.isNullDefault(null,"abc"));
		assertEquals(StringUtil.isNullDefault("a", "abc") , "a");
		assertEquals(StringUtil.isNullDefault("", "abc") , "abc");
		assertEquals(StringUtil.isNullDefault(null, "abc") , "abc");

	}

	@Test
	public void isNullDefault2(){
		assertEquals(StringUtil.isNullDefault("a"), "a");
		assertEquals(StringUtil.isNullDefault(""), "");
		assertEquals(StringUtil.isNullDefault(null), "");
	}


	@Test
	public void test1(){
		int period = 1 ;
		if (period == 1 || period == 3) {
			print("ok");
		}
	}



	
}
