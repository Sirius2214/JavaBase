package main.java.tdh.test.calendarDemo;

import java.util.Calendar;

/**
 * @Author: wangzy
 * @Description: 日期工具类使用
 * @Project Name:test
 * @File Name: CalendarDemo
 * @Package Name:tdh.test.calendarDemo
 * @Copyright (c) 2021,南京通达海信息科技有限公司 All Rights Reserved.
 * Modification History:
 * @Date @TIME      @Author      @Version  Description
 * ------------------------------------------------------------------
 * 2021/04/11 13:57  wangzy     1.0        1.0 Version
 */
public class CalendarDemo {
    /**
     * 主方法
     * @param args 入参
     */
    public static void main(String[] args) {
        // 获取当前的日历时间
        Calendar c = Calendar.getInstance();

        // 获取年
        int year = c.get(Calendar.YEAR);
        // 获取月
        int month = c.get(Calendar.MONTH);
        // 获取日
        int date = c.get(Calendar.DATE);
        System.out.println(year + "年" + (month + 1) + "月" + date + "日");

        // // 三年前的今天
        // c.add(Calendar.YEAR, -3);
        // // 获取年
        // year = c.get(Calendar.YEAR);
        // // 获取月
        // month = c.get(Calendar.MONTH);
        // // 获取日
        // date = c.get(Calendar.DATE);
        // System.out.println(year + "年" + (month + 1) + "月" + date + "日");

        // 5年后的10天前
        c.add(Calendar.YEAR, 5);
        c.add(Calendar.DATE, -10);
        // 获取年
        year = c.get(Calendar.YEAR);
        // 获取月
        month = c.get(Calendar.MONTH);
        // 获取日
        date = c.get(Calendar.DATE);
        System.out.println(year + "年" + (month + 1) + "月" + date + "日");
        System.out.println("--------------");

        c.set(2011, 11, 11);
        // 获取年
        year = c.get(Calendar.YEAR);
        // 获取月
        month = c.get(Calendar.MONTH);
        // 获取日
        date = c.get(Calendar.DATE);
        System.out.println(year + "年" + (month + 1) + "月" + date + "日");
    }
}

