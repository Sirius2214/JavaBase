package main.java.tdh.test.functionDemo;


/**
 * @Author: wangzy
 * @Description: java方法示例
 *
 * 	方法：完成特定功能的代码块。
 *
 * 	注意：在很多语言里面有函数的定义，而在Java中函数被称为方法。
 *
 * 	方法格式：
 * 		修饰符 返回值类型 方法名(参数类型 参数名1,参数类型 参数名2...) {
 * 			方法体语句;
 * 			return 返回值;
 *                }
 * 	详细解释：
 * 		修饰符：目前就用 public static。
 * 		返回值类型：就是功能结果的数据类型。
 * 		方法名：符合命名规则即可。方便我们的调用。
 * 		参数：
 * 			实际参数：就是实际参与运算的。
 * 			形式参数；就是方法定义上的，用于接收实际参数的。
 * 		参数类型：就是参数的数据类型
 * 		参数名：就是变量名
 * 		方法体语句：就是完成功能的代码。
 * 		return：结束方法的。
 * 		返回值：就是功能的结果，由return带给调用者。
 *
 * 	要想写好一个方法，就必须明确两个东西：
 * 		A:返回值类型
 * 			结果的数据类型
 * 		B:参数列表
 * 			你要传递几个参数，以及每个参数的数据类型
 *
 * 	需求：求两个数据之和的案例
 *
 * 	方法的执行特点：
 * 		不调用，不执行。
 *
 * 	如何调用呢?(有明确返回值的调用)
 * 		A:单独调用,一般来说没有意义，所以不推荐。
 * 		B:输出调用,但是不够好。因为我们可能需要针对结果进行进一步的操作。
 * 		C:赋值调用,推荐方案。
 *
 * @Project Name:test
 * @File Name: FunctionDemo
 * @Package Name:tdh.test.functionDemo
 * @Copyright (c) 2021,南京通达海信息科技有限公司 All Rights Reserved.
 * Modification History:
 * @Date @TIME      @Author      @Version  Description
 * ------------------------------------------------------------------
 * 2021/04/11 13:57  wangzy     1.0        1.0 Version
 */
class FunctionDemo {
    /**
     * 主方法
     * @param args 入参
     */
    public static void main(String[] args) {
        int x = 10;
        int y = 20;

        //方式1：单独调用
        //sum(x,y);

        //方式2：输出调用
        //System.out.println(sum(x,y));
        //System.out.println(30);

        //方式3：赋值调用
        int result = sum(x,y);
        //result在这里可以进行操作
        System.out.println(result);
    }

    /**
     * 求两个数据之和
     * @param a 参数1
     * @param b 参数2
     * @return int
     */
    public static int sum(int a,int b) {
        //如何实现呢?
        //int c = a + b;
        //return c;

        //c就是a+b,所以，我可以直接返回a+b
        return a + b;
    }

}