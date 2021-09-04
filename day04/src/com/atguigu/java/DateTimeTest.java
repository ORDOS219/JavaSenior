package com.atguigu.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * SimpleDateFromat 的使用：SimpleDateFromat对日期Date类的格式进行格式化和解析
 * <p>
 * 1.两个操作：
 * <p>
 * 1.1 格式化：将系统给定的Date类对象按照需要的格式进行字符串式格式化输出  xxx.format()
 * 1.2 解析：格式化的逆过程-> 将日期的字符串格式输出为Date类的格式   xxx.parse()
 * <p>
 * 2.SimpleDateFormat的实例化
 *
 * @author yangyang
 * @create 2020-11-18-7:37 下午
 */
public class DateTimeTest {

    @Test
    public void testSimpleDateFormat1() {
        //默认实例化SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date = new Date();
        System.out.println(date.getTime());
        System.out.println("默认初始化： " + sdf.format(date));
    }

    @Test
    public void testSimpleDateFormat2() {
        //指定类型实例化SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();

        System.out.println("按需初始化： " + sdf.format(date));
    }

    @Test
    public void testSimpleDateFormat3() throws ParseException {
        //解析SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = "1998-02-19 19:21:37";
        System.out.println(sdf.parse(date));
    }

    @Test
    /**
     * 字符串"2020-11-19"和 java.sql.Date类型的转换
     */
    public void transDateFormat() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = "2020-11-19";
        Date date1 = sdf.parse(date);
        System.out.println(date1);
        System.out.println(date1.getTime());
        java.sql.Date date2 = new java.sql.Date(date1.getTime());
        System.out.println(date2);

    }

    //Calendar常用的方法
    @Test
    public void CalendarTest() {
        Calendar calendar = Calendar.getInstance();
        //set()方法：
        System.out.println(calendar);
        calendar.set(2020, 11, 20);
        calendar.set(Calendar.DAY_OF_MONTH, 22);
        calendar.set(Calendar.DAY_OF_WEEK, 3);
        //get()方法：
        int time = calendar.get(Calendar.DAY_OF_MONTH);
//        System.out.println("*****"+time);//*****22
        int i = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
//        System.out.println(i);    //4

        //add()方法：
        calendar.add(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
        int i1 = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        System.out.println(time);
        System.out.println(i);
        System.out.println(i1);

        //getTime():
        Date time1 = calendar.getTime();
        System.out.println(time1);

        //setTime():
        Date date = new Date(8739437492934L);
        calendar.setTime(date);
        Date date1 = calendar.getTime();
        System.out.println(date1);

        Date date2 = new Date(2020 - 1900,11 - 1,23);
        System.out.println(date2);


    }

    public static void main(String[] args) throws ParseException {
        DateTimeTest test1 = new DateTimeTest();
//        java.sql.Date date = new java.sql.Date(34792304823842L);
//        System.out.println(date);
        test1.testSimpleDateFormat1();
        test1.testSimpleDateFormat2();
        test1.testSimpleDateFormat3();
    }
}
