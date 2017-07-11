package test.list;

import java.util.LinkedList;
import java.util.List;

/**
 * List的实现类 - LinkedList
 * LinkedList是用链表结构存储数据的，很适合数据的动态插入和删除，随机访问和遍历速度比较慢。另外，接口中没有定义的方法get，remove，
 * insertList，专门用于操作表头和表尾元素，可以当作堆栈、队列和双向队列使用。LinkedList没有同步方法。如果多个线程同时访问一个List，
 * 则必须自己实现访问同步。 <br>
 * 一种解决方法是在创建 List时构造一个同步的List： <br>
 * List list = Collections.synchronizedList(new LinkedList(...));
 * 
 * @author chen
 *
 */
public class LinkedListTest {

	public static void main(String[] args) {

		List<String> list = new LinkedList<>();

	}

}
