package com.atguigu.java;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * * 其他常用类的使用
 * * 1.System
 * * 2.Math
 * * 3.BigInteger 和 BigDecimal
 *
 * @author yangyang
 * @create 2020-11-22-9:37 上午
 */
public class OtherClassTest {
    @Test
    public void Test1() {
        String version = System.getProperty("java.version");
        System.out.println("java.version:" + version);//java.version:11.0.1
        String javaHome = System.getProperty("java.home");
        System.out.println("java.home:" + javaHome);//java.home:/Library/Java/JavaVirtualMachines/jdk-11.0.1.jdk/Contents/Home
        String osName = System.getProperty("os.name");
        System.out.println("os.name:" + osName);//os.name:Mac OS X
        String osVersion = System.getProperty("os.version");
        System.out.println("os.version:" + osVersion);//os.name:Mac OS X
        String userName = System.getProperty("user.name");
        System.out.println("user.name:" + userName);//user.name:yangyang
        String dir = System.getProperty("user.dir");
        System.out.println("user.dir:" + dir);//user.dir:/Users/yangyang/Code Application/IntelliJ IDEA/JavaSenior/day04
    }


    @Test
    public void test2() {
        BigInteger bi = new BigInteger("1243324112234324324325235245346567657653");
        BigDecimal bd = new BigDecimal("12435.351");
        BigDecimal bd2 = new BigDecimal("11");
        System.out.println(bi);
//         System.out.println(bd.divide(bd2));
        System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP));
        System.out.println(bd.divide(bd2, 25, BigDecimal.ROUND_HALF_UP));

    }

}
