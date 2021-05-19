package main.java.tdh.test.xsf.cn;
/**
 * @Author: wangzy
 * @Description: 父类
 * 	权限修饰符：
 * 				  本类  	同一个包下(子类和无关类)	   不同包下(子类)	不同包下(无关类)
 * 		private 	Y
 * 		默认		Y		Y
 * 		protected	Y		Y							Y
 * 		public		Y		Y							Y				Y
 * @Project Name:test
 * @File Name: Father
 * @Package Name:tdh.test.xsf.cn
 * @Copyright (c) 2021,南京通达海信息科技有限公司 All Rights Reserved.
 * Modification History:
 * @Date @TIME      @Author      @Version  Description
 * ------------------------------------------------------------------
 * 2021/04/11 13:57  wangzy     1.0        1.0 Version
 */
public class Father {
	private void show() {
		System.out.println("show");
	}

	void show2() {
		System.out.println("show2");
	}

	protected void show3() {
		System.out.println("show3");
	}

	public void show4() {
		System.out.println("show4");
	}

	/**
	 * 主方法
	 * @param args 入参
	 */
	public static void main(String[] args) {
		Father f = new Father();
		f.show();
		f.show2();
		f.show3();
		f.show4();
	}
}