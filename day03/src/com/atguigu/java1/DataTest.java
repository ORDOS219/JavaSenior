package com.atguigu.java1;

import org.junit.Test;

import java.util.Date;

/**
 * @author yangyang
 * @create 2020-11-08-3:38 下午
 */
/*
*   java.util.Date
*       |---java.sql.Date类
*   1.两个构造器的使用
*       >构造器一：Date:创建了一个对应当前时间的Date对象
*       >构造器二：创建指定毫秒数的Date对象
*   2.两个方法：
*       >toString():显示当前的年，月，日，时，分，秒
*       >getTime():获取当前对象从1970年1月1日0时0分0秒到现在对应的时间戳
*   3.java.sql.Date对应着数据库中日期类型的变量
*       >如何实例化
*           java.sql.Date date5 = new java.sql.Date(long int);
*       >如何将java.util.Date对象转换为java.sql.Date对象
*      //情况一：
*      Date date2 = new java.sql.Date(3412412341534L);
*      System.out.println(date2);
       java.sql.Date date3 = (java.sql.Date)date2;
       //情况二：
       Date date4 = new Date();
       java.sql.Date date5 = new java.sql.Date(date4.getTime());
 */
public class DataTest {
    @Test
    public void Date() {
        //构造器一：Date:创建了一个对应当前时间的Date对象
        Date date = new Date();
//        System.out.println(date);
        System.out.println(date.toString());//显示具体时间，可视化形式
        System.out.println(date.getTime());//显示时间戳
        //构造器二：创建指定毫秒数的Date对象
        Date date1 = new Date(1604822045155L);
        System.out.println(date1);
        System.out.println("************");

        //如何将java.util.Date对象转换成java.sql.Date对象
        //情况一：
//        Date date2 = new java.sql.Date(3412412341534L);
//        System.out.println(date2);
//        java.sql.Date date3 = (java.sql.Date)date2;
        //情况二：
        Date date4 = new Date();
        java.sql.Date date5 = new java.sql.Date(date4.getTime());

    }

    @Test
    public void Test1() {
        long time = System.currentTimeMillis();
        System.out.println(time);
    }

}
