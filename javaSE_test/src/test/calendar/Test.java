package test.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Test {

	public static void main(String[] args) throws ParseException {

		// 自定义一个日期,符合日期格式的(2015-04-00 jdk系统默认是3月了)
		String dateStr = "2015-09-10 00:00:01";

		// 定义转的格式
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		// 将时间格式转为Date对象
		Date date = format.parse(dateStr);

		System.out.println(date.getTime());

		// 创建Calendar对象
		Calendar calendar = Calendar.getInstance();
		// 初始化 Calendar 对象，但并不必要，除非需要重置时间,充值到上面的时间
		calendar.setTime(date);
		System.out.println(calendar);

		// 显示年份
		int year = calendar.get(Calendar.YEAR);
//		System.out.println("YEAR is = " + String.valueOf(year));

		//显示月份
		int MONTH = calendar.get(Calendar.MONTH);
		System.out.println("MONTH is = " + MONTH);
		if(MONTH<9){
			String monthString ="";
			monthString = "0"+String.valueOf(MONTH+1);
			System.out.println("string:"+monthString);
		}

		// 今年的第 N 天
		int DAY_OF_YEAR = calendar.get(Calendar.DAY_OF_YEAR);
//		System.out.println("DAY_OF_YEAR is = " + DAY_OF_YEAR);

		// 本月第 N 天  
	    int DAY_OF_MONTH = calendar.get(Calendar.DAY_OF_MONTH);  
//	    System.out.println("DAY_OF_MONTH = " + String.valueOf(DAY_OF_MONTH));  
	    
	    // 当前分钟数  
	    int MINUTE = calendar.get(Calendar.MINUTE);  
//	    System.out.println("MINUTE = " + MINUTE);  

//		System.out.println(calendar);

		//修改-------------------------
		
		//一个月之后
		calendar.add(Calendar.MONTH, 1);
//		calendar.add(Calendar.DATE, 1);
//		calendar.roll(MONTH, true);
//		MONTH = calendar.get(Calendar.MONTH);
//		System.out.println("月份:"+(MONTH+1));	//是3
	    
		// 15 分钟以后  
//	    calendar.add(Calendar.MINUTE, 15);  
//	    MINUTE = calendar.get(Calendar.MINUTE);  
//	    System.out.println("MINUTE + 15 = " + MINUTE);  
		
//		System.out.println(calendar);	//修改了
		
		// 格式化显示  
	    String str = format.format(calendar.getTime());  
	    System.out.println(str);  
	    		
	}

}
