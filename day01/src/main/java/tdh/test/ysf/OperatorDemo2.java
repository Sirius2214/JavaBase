package main.java.tdh.test.ysf;

/**
 * @Author: wangzy
 * @Description:
 *   赋值运算符：
 * 		基本的赋值运算符：=
 * 			把=右边的数据赋值给左边。
 *
 * 		扩展的赋值运算符：+=,-=,*=,/=,%=
 * 			+= 把左边和右边做加法，然后赋值给左边。
 * @Project Name:test
 * @File Name: OperatorDemo2
 * @Package Name:tdh.test.ysf
 * @Copyright (c) 2021,南京通达海信息科技有限公司 All Rights Reserved.
 * Modification History:
 * @Date @TIME      @Author      @Version  Description
 * ------------------------------------------------------------------
 * 2021/04/11 13:57  wangzy     1.0        1.0 Version
 */
class OperatorDemo2 {
    /**
     * 主方法
     * @param args 入参
     */
    public static void main(String[] args) {
        //定义一个变量
        int x = 10;

        //其他用法
        int a,b;
        a = b = 10;
        System.out.println(a);
        System.out.println(b);
        System.out.println("-----------");

        //定义一个变量
        int y = 10;

        y += 20;

        System.out.println(y);

    }
}