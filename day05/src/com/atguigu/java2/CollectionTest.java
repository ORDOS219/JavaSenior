package com.atguigu.java2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

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
 *                |----ArrayList、LinkedList、Vector
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
 * @create 2020-11-28-4:36 下午
 */
public class CollectionTest {
    @Test
    public void Test1(){
        Collection coll = new ArrayList();
        Collection coll1 = new ArrayList();
        coll.add("王景煦");//单参数
        coll.add("王媛媛");
        coll.add(123);
        coll.add("abc");
        int size = coll.size();//size():查看集合中元素的个数
        System.out.println(size);
        coll1.add("YY");
        coll1.add("wjx");
        coll.addAll(coll1);//将另一个集合中的全部元素全部添加到现在的这个集合中，参数为另外的一个Collection对象
        System.out.println("coll集合的size为：" + coll.size());
        System.out.println(coll);
        boolean empty = coll1.isEmpty();//判断集合中的元素是否为空，而不是判断集合是否为null
        System.out.println(empty);
        coll.clear();//将对象集合中的元素清空，而不回收对象本身
        boolean empty1 = coll.isEmpty();
        System.out.println(empty1);
    }

}
