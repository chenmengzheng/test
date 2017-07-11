package test.list;

import java.util.List;
import java.util.Vector;

/**
 * List的实现类 - Vector
 * 与ArrayList一样，也是通过数组实现的，不同的是它支持线程的同步，即某一时刻只有一个线程能够写Vector，避免多线程同时写而引起的不一致性，
 * 但实现同步需要很高的花费，因此，访问它比访问ArrayList慢。
 * 
 * @author chen
 *
 */
public class VectorTest {
	
	public static void main(String[] args) {
		
		List<String> list = new Vector<>();
		
		
	}

}
