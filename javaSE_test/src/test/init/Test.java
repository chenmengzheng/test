package test.init;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		
		
		TestE t = TestE.c;
		System.out.println(t.ordinal());
		
		
		
	}

	Test(String s) {

	}

	Test(int i) {

	}

	Test(int i, String s) {
		this(i);
//		this(s);
	}
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	// public int f(){
	// return 0;
	// }

}

class Test2 {

	public static void main(String[] args) {

	}

	public void f() {

	}

	public Test2() {
		// TODO Auto-generated constructor stub
	}

	// public int f(){
	// return 0;
	// }

}