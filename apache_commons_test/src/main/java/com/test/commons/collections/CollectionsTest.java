package com.test.commons.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

/**
 * 测试commons.collections包中的方法
 * 
 * commons.collections 扩展或增强Java集合框架。
 * 
 * @author <a href="https://github.com/chenmengzheng">陈梦争</a>
 * @date 2017-7-11 17:05:26
 */
public class CollectionsTest {

	public static void main(String[] args) {

		List<String> aList = new ArrayList<String>();
		aList.add("aaa");
		aList.add("bbb");
		aList.add("ccc");
		List<String> bList = new ArrayList<String>();
		bList.add("aaa");
		bList.add("ddd");
		bList.add("eee");
		// 并集 ss
		Collection<String> unionList = CollectionUtils.union(aList, bList);
		// 交集
		Collection<String> intersectionList = CollectionUtils.intersection(aList, bList);
		// 是否存在交集
		boolean isContained = CollectionUtils.containsAny(aList, bList);
		// 交集的补集
		Collection<String> disjunctionList = CollectionUtils.disjunction(aList, bList);
		// 集合相减
		Collection<String> subtractList = CollectionUtils.subtract(aList, bList);

		// 排序
		Collections.sort((List<String>) unionList);
		Collections.sort((List<String>) intersectionList);
		Collections.sort((List<String>) disjunctionList);
		Collections.sort((List<String>) subtractList);

		// 测试
		System.out.println("A: " + ArrayUtils.toString(aList.toArray()));
		System.out.println("B: " + ArrayUtils.toString(bList.toArray()));
		System.out.println("A has one of B? : " + isContained);
		System.out.println("Union(A, B): " + ArrayUtils.toString(unionList.toArray()));
		System.out.println("Intersection(A, B): " + ArrayUtils.toString(intersectionList.toArray()));
		System.out.println("Disjunction(A, B): " + ArrayUtils.toString(disjunctionList.toArray()));
		System.out.println("Subtract(A, B): " + ArrayUtils.toString(subtractList.toArray()));

	}

}
