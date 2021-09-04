package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 *   一、集合框架的概述
 *
 *   1.集合、数组都是对多个数据进行存储操作的结构，简称Java容器。
 *    说明：此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储（.txt,.jpg,.avi，数据库中）
 *
 *   2.1 数组在存储多个数据方面的特点：
 *        > 一旦初始化以后，其长度就确定了。
 *        > 数组一旦定义好，其元素的类型也就确定了。我们也就只能操作指定类型的数据了。
 *         比如：String[] arr;int[] arr1;Object[] arr2;
 *   2.2 数组在存储多个数据方面的缺点：
 *        > 一旦初始化以后，其长度就不可修改。
 *        > 数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便，同时效率不高。
 *        > 获取数组中实际元素的个数的需求，数组没有现成的属性或方法可用
 *        > 数组存储数据的特点：有序、可重复。对于无序、不可重复的需求，不能满足。
 *
 *   二、集合框架
 *        |----Collection接口：单列集合，用来存储一个一个的对象
 *            |----List接口：存储有序的、可重复的数据。  -->“动态”数组
 *                |----ArrayList：
 *                |----LinkedList：
 *                |----Vector：
 *
 *            |----Set接口：存储无序的、不可重复的数据   -->高中讲的“集合”
 *                |----HashSet、LinkedHashSet、TreeSet
 *
 *        |----Map接口：双列集合，用来存储一对(key - value)一对的数据   -->高中函数：y = f(x)
 *                |----HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 *
 *
 *   三、Collection接口中声明的方法使用的测试：
 *      结论：
 *      向Collection接口的实现类的对象中添加数据obj时，要求重写obj所在类中的equals()
 *
 * @author yangyang
 * @create 2020-11-28-7:19 下午
 */
public class CollectionTest {

    @Test
    public void Test1() {
        //1.contains()方法测试：
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add("ABC");
        coll.add(true);
        coll.contains(123);//true
        coll.add(new String("小明"));//true， 因为String中对equals()进行了重写
        //2.contains(Object obj),调用obj所在类中的equals()方法，并将Collection对象依次作为equals()方法的参数进行判断
        boolean contains1 = coll.contains(new Person("张三", 20));
        System.out.println(contains1);

        Collection coll1 = Arrays.asList(123, "小明");
        boolean containsAll = coll.containsAll(coll1);
        System.out.println(containsAll);
    }

    @Test
    public void Test2() {

        Collection coll = new ArrayList();
        //3.remove(Object obj):从当前集合移除obj
        coll.add(123);
        coll.add(456);
        coll.add("ABC");
        coll.add(true);
        coll.add(new String("小明"));

        System.out.println(coll);
        coll.remove(1234);
        System.out.println(coll);

        //4.removeAll(Collection coll1):差集：从当前集合中移除所有coll1中的元素

        Collection coll1 = Arrays.asList(123, 4567);
        coll.removeAll(coll1);
        System.out.println(coll);
        System.out.println(coll1);
    }

    @Test
    public void Test3() {

        //5.retainAll(Object obj):交集：获取当前集合和obj集合中相同的元素并赋值给调用的对象
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("ABC");
        coll.add(true);
        coll.add(new Person("小明", 20));

        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll1.add(456);
        coll.retainAll(coll1);
        System.out.println(coll);
        //6.equals(Object obj):判断当前集合与形参集合中的元素是否都相等
        Collection coll2 = new ArrayList();
        coll2.add(123);
        coll2.add(456);

        boolean equals = coll1.equals(coll2);

        System.out.println(coll1);
        System.out.println(coll2);
        System.out.println(equals);
    }

    @Test
    public void Test4(){
        //7.hashCode():返回当前对象的哈希值
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("ABC");
        coll.add(true);
        coll.add(new Person("小明", 20));
        int hashCode = coll.hashCode();
        System.out.println(hashCode);

        //8.集合 ---> 数组：toArray():将当前的集合转换为数组Object[]
        Object[] toArray = coll.toArray();
        System.out.println(toArray);//输出为地址值

        for(int i = 0; i < toArray.length; i++){
            System.out.println(toArray[i]);
        }
        //拓展：数组 ---> 集合：调用Array类的静态方法asList()
        List<String> strings = Arrays.asList(new String[]{"小明", "小王"});
        System.out.println(strings);

        //注意：调用asList()时候要注意：
        List<int[]> ints = Arrays.asList(new int[]{123, 456});
        System.out.println(ints);//[[I@5891e32e] 将new int[]{123, 456}当成了一个整体对象
        //可以改成包装类Intrger
        List ints1 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(ints1);//[123, 456]

    }
}