package test.annotation.test5;

public class TestClass {
	
	@Model(name="xxx")
	public String TestMethod(TestIn testIn,@Field String arg){
		
		System.out.println(testIn.getFundId());
		
		return null;
	}
	

}
