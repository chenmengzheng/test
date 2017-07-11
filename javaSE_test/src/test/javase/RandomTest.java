package test.javase;

import java.util.Random;

/**
 * 利用javaSE产生随机数<br>
 * Random类测试
 * 
 * @author chen
 *
 */
public class RandomTest {

	public static void main(String[] args) {
		System.out.println(randInt(10, 100));
	}

	//返回min-max,可以相等.
	public static int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

}
