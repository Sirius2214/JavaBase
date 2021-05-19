package main.java.tdh.test.list;

/**
 * @Author: wangzy
 * @Description: 学生类
 * @Project Name:test
 * @File Name: Student
 * @Package Name:tdh.test.list
 * @Copyright (c) 2021,南京通达海信息科技有限公司 All Rights Reserved.
 * Modification History:
 * @Date @TIME      @Author      @Version  Description
 * ------------------------------------------------------------------
 * 2021/04/11 13:57  wangzy     1.0        1.0 Version
 */
public class Student {
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 年龄
	 */
	private int age;

	/**
	 * 无参构造方法
	 */
	public Student() {
		super();
	}


	/**
	 * 有参构造方法
	 * @param name 姓名
	 * @param age 年龄
	 */
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	/**
	 * 获取姓名
	 * @return String 姓名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置姓名
	 * @param name 姓名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取年龄
	 * @return int 年龄
	 */
	public int getAge() {
		return age;
	}

	/**
	 * 设置年龄
	 * @param age 年龄
	 */
	public void setAge(int age) {
		this.age = age;
	}

}
