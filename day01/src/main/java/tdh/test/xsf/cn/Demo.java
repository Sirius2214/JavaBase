package main.java.tdh.test.xsf.cn;
/**
 * @Author: wangzy
 * @Description: 修饰符
 * 	修饰符：
 * 		权限修饰符：private，默认的，protected，public
 * 		状态修饰符：static，final
 * 		抽象修饰符：abstract
 *
 * 	类：
 * 		权限修饰符：默认修饰符，public
 * 		状态修饰符：final
 * 		抽象修饰符：abstract
 *
 * 		用的最多的就是：public
 *
 * 	成员变量：
 * 		权限修饰符：private，默认的，protected，public
 * 		状态修饰符：static，final
 *
 * 		用的最多的就是：private
 *
 * 	构造方法：
 * 		权限修饰符：private，默认的，protected，public
 *
 * 		用的最多的就是：public
 *
 * 	成员方法：
 * 		权限修饰符：private，默认的，protected，public
 * 		状态修饰符：static，final
 * 		抽象修饰符：abstract
 *
 * 		用的最多的就是：public
 *
 * 	除此以外的组合规则：
 * 		成员变量：public static final
 * 		成员方法：public static
 * 		          public abstract
 * 				  public final
 * @Project Name:test
 * @File Name: SetDemo
 * @Package Name:tdh.test.jdbc
 * @Copyright (c) 2021,南京通达海信息科技有限公司 All Rights Reserved.
 * Modification History:
 * @Date @TIME      @Author      @Version  Description
 * ------------------------------------------------------------------
 * 2021/04/11 13:57  wangzy     1.0        1.0 Version
 */
public class Demo {
	//成员变量
	private int x = 10;
	int y = 20;
	protected int z = 30;
	public int a = 40;
	public final int b = 50;
	public static int c = 60;
	public static final int d = 70;
	//此处不允许使用修饰符abstract
	//abstract int e = 80;

	//构造方法
	private Demo(){}

	Demo(String name){}

	protected Demo(String name,int age) {}

	public Demo(String name,int age,String address) {}

	//此处不允许使用修饰符static
	//public static Demo(){}
	//此处不允许使用修饰符final
	//public final Demo() {}
	//此处不允许使用修饰符abstract
	//public abstract Demo(){}

	//成员方法
	//static void show() {}
	//abstract void show();
	//final void show(){}
}