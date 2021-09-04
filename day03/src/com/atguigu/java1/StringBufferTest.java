package com.atguigu.java1;

import org.junit.Test;

/**
 * @author yangyang
 * @create 2020-11-08-2:54 下午
 */
public class StringBufferTest {
    @Test
    public void test1(){
        StringBuffer sb1 = new StringBuffer();
////        sb1.append(1);
////        sb1.append('1');
////        sb1.append('a');
//        sb1.append("11aabcd");
////        System.out.println(sb1);
////        sb1.delete(1,3);
//        sb1.replace(1,3,"234");
////        System.out.println(sb1);
//        System.out.println("sb1的长度" + sb1.capacity());
////        System.out.println("sb1的内容长度" + sb1.length());
        sb1.append("123456789");
//        sb1.reverse();
        int local = sb1.indexOf("56");
        System.out.println(sb1);
        System.out.println(local);
        String substring = sb1.substring(3);
        System.out.println(substring);

//        System.out.println("sb1的长度" + sb1.capacity());
//        System.out.println("sb1的内容长度" + sb1.length());
////        sb1.append("abcdefghijklmnopq");
//        System.out.println(sb1.length());
//        sb1.append('a');
//        System.out.println("有效长度" + sb1.length());
//        System.out.println("扩容后：" + sb1.capacity());


    }
}
