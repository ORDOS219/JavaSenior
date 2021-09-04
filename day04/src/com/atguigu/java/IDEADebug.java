package com.atguigu.java;

import org.junit.Test;

/**
 * @author yangyang
 * @create 2020-11-18-11:08 上午
 */
public class IDEADebug {
    @Test
    public void testStringBuffer() {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);//

        System.out.println(sb.length());//4

        System.out.println(sb);//"null"

        StringBuffer sb1 = new StringBuffer(str);//抛异常NullPointerException
        System.out.println(sb1);//
    }
}
