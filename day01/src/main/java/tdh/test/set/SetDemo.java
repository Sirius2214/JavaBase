package main.java.tdh.test.set;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: wangzy
 * @Description: set集合
 * Collection
 * 		|--List
 * 			有序(存储顺序和取出顺序一致),可重复
 * 		|--Set
 * 			无序(存储顺序和取出顺序不一致),唯一
 *
 * HashSet：它不保证 set 的迭代顺序；特别是它不保证该顺序恒久不变。
 * 注意：虽然Set集合的元素无序，但是，作为集合来说，它肯定有它自己的存储顺序，
 * 而你的顺序恰好和它的存储顺序一致，这代表不了有序，你可以多存储一些数据，就能看到效果。
 *
 * @Project Name:test
 * @File Name: SetDemo
 * @Package Name:tdh.test.jdbc
 * @Copyright (c) 2021,南京通达海信息科技有限公司 All Rights Reserved.
 * Modification History:
 * @Date @TIME      @Author      @Version  Description
 * ------------------------------------------------------------------
 * 2021/04/11 13:57  wangzy     1.0        1.0 Version
 */
public class SetDemo {
    /**
     * 主方法
     * @param args 入参
     */
    public static void main(String[] args) {
        // 创建集合对象
        Set<String> set = new HashSet<String>();

        // 创建并添加元素
        set.add("hello");
        set.add("java");
        set.add("world");
        set.add("java");
        set.add("world");


        // 增强for
        for (String s : set) {
            System.out.println(s);
        }
    }
}