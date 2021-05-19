package main.java.tdh.test.ysf;


/**
 * @Author: wangzy
 * @Description: 三目运算符
 * 	三目运算符：
 * 		格式：比较表达式?表达式1:表达式2;
 *
 * 		比较表达式:结果是一个boolean类型。
 *
 * 		执行流程：
 * 			根据比较表达式的计算返回一个true或者false。
 * 			如果是true，就把表达式1作为结果。
 * 			如果是false，就把表达式2作为结果。
 * @Project Name:test
 * @File Name: OperatorDemo
 * @Package Name:tdh.test.ysf
 * @Copyright (c) 2021,南京通达海信息科技有限公司 All Rights Reserved.
 * Modification History:
 * @Date @TIME      @Author      @Version  Description
 * ------------------------------------------------------------------
 * 2021/04/11 13:57  wangzy     1.0        1.0 Version
 */
class OperatorDemo5 {
    /**
     * 主方法
     * @param args 入参
     */
    public static void main(String[] args) {
        int x = 100;
        int y = 200;

        int z = ((x > y)? x: y);

        //int z = ((x < y)? x: y);

        //int z = ((x == y)? x: y);

        //报错
        //int z = ((x = y)? x : y);

        System.out.println("z:"+z);
    }
}