package com.atguigu.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * jdk 8中日期时间API的测试
 *
 * @author yangyang
 * @create 2020-11-20-9:26 上午
 */
public class JDK8DateTest {
    /*
        LocalDate、LocalTime、LocalDateTime 的使用
    */
    @Test
    public void Test() {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //设置指定的年月日时分秒，没有时间偏移量，不像Date的带参构造器有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 11, 21, 10, 27, 49);
        System.out.println(localDateTime);

        //getXxx()
        System.out.println(LocalDateTime.MAX.getDayOfYear());
        System.out.println(LocalDateTime.now().getDayOfYear());
        System.out.println(localDateTime1.getDayOfYear());
        System.out.println(localDateTime.getMonthValue() + "," + localDateTime.getDayOfMonth() + "," + localDateTime.getYear() + " "
                + localDateTime.getHour() + ":" + localDateTime.getMinute() + ":" + localDateTime.getSecond());
        System.out.println();


    }

    /*    Instant的使用
            类似于 java.util.Date类*/
    @Test
    public void test2() {
        //对应本初子午线的时间，比我们慢8小时
        Instant instant = Instant.now();
        System.out.println(instant);//2020-11-21T08:13:16.263002Z
        System.out.println("***************");
        //添加时间偏移量
        OffsetDateTime offset = instant.atOffset(ZoneOffset.ofHours(8));//2020-11-21T16:13:16.263002+08:00
        System.out.println(offset);
        //toEpochMilli()：获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数  ---> Date类的getTime()
        long milli = instant.toEpochMilli();
        System.out.println(milli);//1605946640504
        //ofEpochMilli():通过给定的毫秒数，获取Instant实例  -->Date(long millis)
        Instant instant1 = Instant.ofEpochMilli(1605946640504L);
        System.out.println(instant1);//2020-11-21T08:17:20.504Z


    }

    @Test
    public void test3(){
//        方式一：预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化:日期-->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);//2019-02-18T15:42:18.797

        //解析：字符串 -->日期
        TemporalAccessor parse = formatter.parse("2019-02-18T15:42:18.797");
        System.out.println(parse);

//        方式二：
//        本地化相关的格式。如：ofLocalizedDateTime()
//        FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT :适用于LocalDateTime
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        //格式化
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);//2019年2月18日 下午03时47分16秒


//      本地化相关的格式。如：ofLocalizedDate()
//      FormatStyle.FULL / FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT : 适用于LocalDate
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        //格式化
        String str3 = formatter2.format(LocalDate.now());
        System.out.println(str3);//2019-2-18


//       重点： 方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String str4 = formatter3.format(LocalDateTime.now());
        System.out.println(str4);//2019-02-18 03:52:09

        //解析
        TemporalAccessor accessor = formatter3.parse("2019-02-18 03:52:09");
        System.out.println(accessor);

    }
}
