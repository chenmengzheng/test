package test.reflect;

/**
 * 测试反射
 * @author chen
 *
 */
public class Car {
	
	private String brand;  
    private String color;  
    private int maxSpeed;  
      
     //①默认构造函数  
    public Car(){}  
       
     //②带参构造函数  
    public Car(String brand,String color,int maxSpeed){   
        this.brand = brand;  
        this.color = color;  
        this.maxSpeed = maxSpeed;  
    }  
  
     //③未带参的方法  
    public void introduce() {   
       System.out.println("brand:"+brand+";color:"+color+";maxSpeed:" +maxSpeed);  
    }

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}  

    
	

}
