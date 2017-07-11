package test.list;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayList是最常用的List实现类，内部是通过数组实现的，它允许对元素进行快速随机访问。<br>
 * 数组的缺点是每个元素之间不能有间隔，当数组大小不满足时需要增加存储能力，就要将已经有数组的数据复制到新的存储空间中。
 * 当从ArrayList的中间位置插入或者删除元素时，需要对数组进行复制、 移动、代价比较高。因此，它适合随机查找和遍历，不适合插入和删除，允许空元素
 * 
 * @author chen
 *
 */
public class ArrayListTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		
	}

}
