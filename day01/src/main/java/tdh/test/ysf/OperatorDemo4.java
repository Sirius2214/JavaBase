package main.java.tdh.test.ysf;

/*

*/

/**
 * @Author: wangzy
 * @Description: 逻辑运算符
 *  逻辑运算符：
 * 		&,|,^,!
 * 		&&,||
 *
 * 	特点：
 * 		逻辑运算符一般用于连接boolean类型的表达式或者值。
 *
 * 		表达式：就是用运算符把常量或者变量连接起来的符合java语法的式子。
 * 			算术表达式：a + b
 * 			比较表达式：a == b
 *
 * 	结论：
 * 		&逻辑与:有false则false。
 * 		|逻辑或:有true则true。
 * 		^逻辑异或:相同为false，不同为true。
 * 			举例：情侣关系。男男,男女,女男,女女
 * 		!逻辑非:非false则true，非true则false。
 * 			特点：偶数个不改变本身。
 * @Project Name:test
 * @File Name: OperatorDemo4
 * @Package Name:tdh.test.ysf
 * @Copyright (c) 2021,南京通达海信息科技有限公司 All Rights Reserved.
 * Modification History:
 * @Date @TIME      @Author      @Version  Description
 * ------------------------------------------------------------------
 * 2021/04/11 13:57  wangzy     1.0        1.0 Version
 */
class OperatorDemo4 {
    /**
     * 主方法
     * @param args 入参
     */
    public static void main(String[] args) {
        int a = 3;
        int b = 4;
        int c = 5;

        //&逻辑与
        System.out.println((a > b) & (a > c)); //false & false = false
        System.out.println((a > b) & (a < c)); //false & true = false
        System.out.println((a < b) & (a > c)); //true & false = false
        System.out.println((a < b) & (a < c)); //true & true = true
        System.out.println("---------------");

        //|逻辑或
        System.out.println((a > b) | (a > c)); //false | false = false
        System.out.println((a > b) | (a < c)); //false | true = true
        System.out.println((a < b) | (a > c)); //true | false = true
        System.out.println((a < b) | (a < c)); //true | true = true
        System.out.println("---------------");


        //&&双与
        System.out.println((a > b) && (a > c)); //false && false = false
        System.out.println((a > b) && (a < c)); //false && true = false
        System.out.println((a < b) && (a > c)); //true && false = false
        System.out.println((a < b) && (a < c)); //true && true = true
        System.out.println("----------------");

        int x = 3;
        int y = 4;

        //boolean b1 = ((x++ == 3) & (y++ == 4));
        //boolean b1 = ((x++ == 3) && (y++ == 4));
        //boolean b1 = ((++x == 3) & (y++ == 4));
        boolean b1 = ((++x == 3) && (y++ == 4));
        System.out.println("x:"+x);
        System.out.println("y:"+y);
        System.out.println(b1);

        //!逻辑非
        System.out.println(!(a > b)); //!false = true
        System.out.println(!(a < b)); //!true = false
        System.out.println(!!(a > b)); //!!false = false
        System.out.println(!!!(a > b)); //!!false = true
    }
}
