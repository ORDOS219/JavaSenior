package com.atguigu.java;

import org.junit.Test;

import java.util.*;

/**
 * 泛型的使用
 * 1.jdk1.5新增的特性
 * 2.在集合中使用泛型：
 * 总结：
 * ①集合接口或集合类在jdk1.5时都修改为带泛型的结构
 * ②在实例化集合类时，可以指明具体泛型类型
 * ③指明完以后，在集合类或接口中凡是定义类或接口时，内部结构（比如：方法、构造器、属性等等）使用到类的泛型的位置，都指定为实例化的泛型的类型
 * 比如：add(E e) ---> 实例化以后：add(Integer e)
 * ④注意点：泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，拿包装类替换
 * ⑤如果实例化时，没有指明泛型的类型，默认类型为java.lang.Object类型。
 * 3.如何自定义泛型结构：泛型类、泛型接口；泛型方法。见 GenericTest1.java
 *
 * @author yangyang
 * @create 2020-12-20-5:05 下午
 */
public class GenericTest {
    @Test
    public void Test1() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("zhangsan", 89);
        map.put("lisi", 86);
        map.put("wangwu", 92);//编译时就会进行检查，保证数据的安全

        //泛型的嵌套
        Set<Map.Entry<String, Integer>> set = map.entrySet();

        Iterator<Map.Entry<String, Integer>> iterator = set.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();
            System.out.println(key + "--->" + value);
        }
    }

    @Test
    public void Test2() {
        SubOrder sub = new SubOrder();
        //由于子类在继承带泛型的父类时，指明了泛型类型。则实例化子类对象时，不再需要指明泛型。
        sub.setOrderT(1122);

        SubOrder1<String> sub1 = new SubOrder1<>();//实例化的时候需要将<泛型>补上
        sub1.setOrderT("abcd");

    }

    //测试泛型类
    @Test
    public void Test3() {
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1, 2, 3, 4};
        List<Integer> integers = order.copyFromArrayToList(arr);
        System.out.println(integers);
    }

}