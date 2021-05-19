package main.java.tdh.test.xsf.cn;

/**
 * @Author: wangzy
 * @Description: 子类2
 * @Project Name:test
 * @File Name: Son2
 * @Package Name:tdh.test.xsf.cn
 * @Copyright (c) 2021,南京通达海信息科技有限公司 All Rights Reserved.
 * Modification History:
 * @Date @TIME      @Author      @Version  Description
 * ------------------------------------------------------------------
 * 2021/04/11 13:57  wangzy     1.0        1.0 Version
 */
public class Son2 extends Father {
	/**
	 * 主方法
	 * @param args 入参
	 */
	public static void main(String[] args) {
		Father f = new Father();
		//f.show();
		//f.show2();
		//f.show3();
		f.show4();
		System.out.println("--------------");
		
		Son2 s = new Son2();
		//s.show();
		//s.show2();
		s.show3();
		s.show4();
	}
}