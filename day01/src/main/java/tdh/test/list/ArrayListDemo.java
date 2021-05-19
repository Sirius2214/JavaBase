package main.java.tdh.test.list;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author: wangzy
 * @Description: ArrayList示例
 *  使用List的任何子类存储字符串或者存储自定义对象并遍历。
 *
 *  ArrayList的使用。
 *  存储字符串并遍历
 *
 * @Project Name:test
 * @File Name: ArrayListDemo
 * @Package Name:tdh.test.list
 * @Copyright (c) 2021,南京通达海信息科技有限公司 All Rights Reserved.
 * Modification History:
 * @Date @TIME      @Author      @Version  Description
 * ------------------------------------------------------------------
 * 2021/04/11 13:57  wangzy     1.0        1.0 Version
 */
public class ArrayListDemo {
	/**
	 * 主方法
	 * @param args 入参
	 */
	public static void main(String[] args) {
		// 创建集合对象
		ArrayList array = new ArrayList();

		// 创建元素对象，并添加元素
		array.add("hello");
		array.add("world");
		array.add("java");

		// 遍历
		Iterator it = array.iterator();
		while (it.hasNext()) {
			String s = (String) it.next();
			System.out.println(s);
		}

		System.out.println("-----------");

		for (int x = 0; x < array.size(); x++) {
			String s = (String) array.get(x);
			System.out.println(s);
		}
	}
}