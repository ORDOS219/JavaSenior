package com.atguigu.java;

/**
 * @author yangyang
 * @create 2020-11-12-9:15 下午
 */
class A {
    public static void main(String[] args) {
        String array = "123456789";
        StringDemo stringDemo = new StringDemo();
        String reverse = stringDemo.reverse(array, 2, 6);
        System.out.println(reverse);
    }
}
