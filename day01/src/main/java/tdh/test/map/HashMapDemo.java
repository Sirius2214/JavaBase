package main.java.tdh.test.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * @Author: wangzy
 * @Description: Map集合的功能概述：
 * 1:添加功能
 * 		V put(K key,V value):添加元素。这个其实还有另一个功能?先不告诉你，等会讲
 * 			如果键是第一次存储，就直接存储元素，返回null
 * 			如果键不是第一次存在，就用值把以前的值替换掉，返回以前的值
 * 2:删除功能
 * 		void clear():移除所有的键值对元素
 * 		V remove(Object key)：根据键删除键值对元素，并把值返回
 * 3:判断功能
 * 		boolean containsKey(Object key)：判断集合是否包含指定的键
 * 		boolean containsValue(Object value):判断集合是否包含指定的值
 * 		boolean isEmpty()：判断集合是否为空
 * 4:获取功能
 * 		Set<Map.Entry<K,V>> entrySet():???
 * 		V get(Object key):根据键获取值
 * 		Set<K> keySet():获取集合中所有键的集合
 * 		Collection<V> values():获取集合中所有值的集合
 * 5：长度功能
 * 		int size()：返回集合中的键值对的对数
 * @Project Name:test
 * @File Name: HashMapDemo
 * @Package Name:tdh.test.map
 * @Copyright (c) 2021,南京通达海信息科技有限公司 All Rights Reserved.
 * Modification History:
 * @Date @TIME      @Author      @Version  Description
 * ------------------------------------------------------------------
 * 2021/04/11 13:57  wangzy     1.0        1.0 Version
 */
public class HashMapDemo {
    /**
     * 主方法
     * @param args 入参
     */
    public static void main(String[] args) {
        // 创建集合对象
        Map<String, String> map = new HashMap<String, String>();

        // 添加元素
        //V put(K key,V value):添加元素。
         System.out.println("put:" + map.put("001", "马云"));
         System.out.println("put:" + map.put("002", "马化腾"));

        map.put("001", "马云");
        map.put("002", "马化腾");
        map.put("003", "雷军");
        map.put("004", "张一鸣");
        map.put("005", "王兴");

        // void clear():移除所有的键值对元素
        // map.clear();

        // V remove(Object key)：根据键删除键值对元素，并把值返回
        // System.out.println("remove:" + map.remove("001"));
        // System.out.println("remove:" + map.remove("002"));

        // boolean containsKey(Object key)：判断集合是否包含指定的键
        // System.out.println("containsKey:" + map.containsKey("001"));
        // System.out.println("containsKey:" + map.containsKey("002"));

        // boolean isEmpty()：判断集合是否为空
        // System.out.println("isEmpty:"+map.isEmpty());

        //int size()：返回集合中的键值对的对数
        System.out.println("size:"+map.size());

        // 输出集合名称
        System.out.println("map:" + map);

        // 遍历
        // 获取所有的键
        Set<String> set = map.keySet();
        // 遍历键的集合，获取得到每一个键
        for (String key : set) {
            // 根据键去找值
            String value = map.get(key);
            System.out.println(key + "---" + value);
        }
    }
}
