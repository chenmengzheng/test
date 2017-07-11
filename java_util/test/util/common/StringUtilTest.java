package util.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import util.common.StringUtil;

@RunWith(MockitoJUnitRunner.class)
public class StringUtilTest {
	
	@Test
	public void getString(){
		System.out.println(StringUtil.getString("","meng"));
	}
	
	@Test
	public void isEmpty(){
		System.out.println(StringUtil.isEmpty("chen"));
	}
	
	@Test
	public void getLeft(){
		System.out.println(StringUtil.getLeft("chehmenghzeng", 5));
	}
	
	@Test
	public void getRight(){
		System.out.println(StringUtil.getRight("chenmenghzeng", 3));
	}
	
	@Test
	public void test_indexOfAnyBut(){
		System.out.println(StringUtil.indexOfAnyBut("aba", 'a','b'));
	}
	
	@Test
	public void test_substringBefore(){
		System.out.println(StringUtil.substringAfter("abdcgdcef", "dcaa"));
	}
	
	@Test
	public void test_substringBetween(){
		String[] str = StringUtil.substringsBetween("12c12c893d45d123c78d77", "c", "d");
		System.out.println(str);
		
	}
	
	
}
