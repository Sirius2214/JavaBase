package main.java.tdh.test.extend;
/**
 * @Author: wangzy
 * @Description: java继承联系
 * 继承概述：
 * 		把多个类中相同的内容给提取出来定义到一个类中。
 *
 * 	如何实现继承呢?
 * 		Java提供了关键字：extends
 *
 * 	格式：
 * 		class 子类名 extends 父类名 {}
 *
 * 	好处：
 * 		A:提高了代码的复用性
 * 		B:提高了代码的维护性
 * 		C:让类与类之间产生了关系，是多态的前提
 *
 * 	类与类产生了关系，其实也是继承的一个弊端：
 * 		类的耦合性增强了。
 *
 * 		开发的原则：低耦合，高内聚。
 * 		耦合：类与类的关系
 * 		内聚：就是自己完成某件事情的能力
 *
 * 	//使用继承前
 * /*
 * class Student {
 * 	public void eat() {
 * 		System.out.println("吃饭");
 *        }
 *
 * 	public void sleep() {
 * 		System.out.println("睡觉");
 *    }
 * }
 *
 * class Teacher {
 * 	public void eat() {
 * 		System.out.println("吃饭");
 *    }
 *
 * 	public void sleep() {
 * 		System.out.println("睡觉");
 *    }
 * }
 * @Project Name:test
 * @File Name: ExtendsDemo
 * @Package Name:tdh.test.extend
 * @Copyright (c) 2021,南京通达海信息科技有限公司 All Rights Reserved.
 * Modification History:
 * @Date @TIME      @Author      @Version  Description
 * ------------------------------------------------------------------
 * 2021/04/11 13:57  wangzy     1.0        1.0 Version
 */
/**
 * @Author: wangzy
 * @Description: 继承父类
 * @Project Name:test
 * @File Name: Person
 * @Package Name:tdh.test.extend
 * @Copyright (c) 2021,南京通达海信息科技有限公司 All Rights Reserved.
 * Modification History:
 * @Date @TIME      @Author      @Version  Description
 * ------------------------------------------------------------------
 * 2021/04/11 13:57  wangzy     1.0        1.0 Version
 */
class Person {
    /**
     * 吃饭
     */
    public void eat() {
        System.out.println("吃饭");
    }

    /**
     * 睡觉
     */
    public void sleep() {
        System.out.println("睡觉");
    }
}

/**
 * @Author: wangzy
 * @Description: 学生类
 * @Project Name:test
 * @File Name: Student
 * @Package Name:tdh.test.extend
 * @Copyright (c) 2021,南京通达海信息科技有限公司 All Rights Reserved.
 * Modification History:
 * @Date @TIME      @Author      @Version  Description
 * ------------------------------------------------------------------
 * 2021/04/11 13:57  wangzy     1.0        1.0 Version
 */
class Student extends Person {}

/**
 * @Author: wangzy
 * @Description: 老师类
 * @Project Name:test
 * @File Name: Teacher
 * @Package Name:tdh.test.extend
 * @Copyright (c) 2021,南京通达海信息科技有限公司 All Rights Reserved.
 * Modification History:
 * @Date @TIME      @Author      @Version  Description
 * ------------------------------------------------------------------
 * 2021/04/11 13:57  wangzy     1.0        1.0 Version
 */
class Teacher extends Person {}

/**
 * @Author: wangzy
 * @Description: 继承演示demo类
 * @Project Name:test
 * @File Name: ExtendsDemo
 * @Package Name:tdh.test.extend
 * @Copyright (c) 2021,南京通达海信息科技有限公司 All Rights Reserved.
 * Modification History:
 * @Date @TIME      @Author      @Version  Description
 * ------------------------------------------------------------------
 * 2021/04/11 13:57  wangzy     1.0        1.0 Version
 */
class ExtendsDemo {
    /**
     * 主方法
     * @param args 入参
     */
    public static void main(String[] args) {
        Student s = new Student();
        s.eat();
        s.sleep();
        System.out.println("-------------");
        Teacher t = new Teacher();
        t.eat();
        t.sleep();
    }
}
