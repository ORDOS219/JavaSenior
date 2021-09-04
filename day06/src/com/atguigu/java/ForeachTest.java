package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * foreach测试：
 * 可以遍历集合，也可以遍历数组
 * 格式：
 *
 * 遍历集合：
 *   for(集合中元素的类型 临时变量 ： 集合的名字){
 *
 *   }
 *
 *   遍历数组：
 *   for(数组中元素的类型 临时变量 ： 数组名){
 *
 *   }
 *
 * @author yangyang
 * @create 2020-11-29-9:16 下午
 */
public class ForeachTest {

    @Test
    public void Test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("ABC");
        coll.add(true);
        coll.add(new Person("小明", 20));

        Iterator iterator = coll.iterator();//创建coll的迭代器对象

        for(Object obj : coll){     //原理：将每一个coll中的元素取出来赋值给obj，然后obj将其输出；然后再取。。。
            System.out.println(obj);
        }
    }

    @Test
    //面试题：
    public void Test2(){

        //方式一：
        String[] arr = new String[]{"MM","MM","MM"};
//        for(int i = 0; i < arr.length; i++){
//            arr[i] = "GG";
//        }
        //方式二：
        for(String str : arr){  //原理：将每一个coll中的元素取出来赋值给obj，然后obj将其输出；然后再取。。。
            str = "GG";         //实质上是赋值给了一个临时变量，不改变原来的值
        }

        for(String str : arr){
            System.out.println(str);
        }
    }

}

