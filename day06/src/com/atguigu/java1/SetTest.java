package com.atguigu.java1;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Set接口的框架：
 *|----Collection接口：单列集合，用来存储一个一个的对象
 *   |----Set接口：存储无序的、不可重复的数据   -->高中讲的“集合”
 *      |----HashSet：作为Set接口的主要实现类；线程不安全；可以存储null值;底层是数组+链表
 *          |----LinkedHashSet：是HashSet的子类；遍历其内部数据时，可按照添加的顺序遍历
 *                  对于频繁的遍历操作，LinkedHashSet效率要高于HashSet
 *      |----TreeSet：可以按照所添加数据的指定属性进行排序
 *
 * 1.set接口中没有额外定义新的方法，使用的都是Collection中声明的方法
 *
 * 2.要求：向Set中添加的数据，其所在的类一定要重写hashCode()和equals()方法
 *   要求：重写的hashCode()和equals()尽可能保持一致性：相等的对象必须具有相等的散列码(哈希值)
 *          重写两个方法的技巧：对象中用作equals()方法比较的Field,都应该用来计算hashCode值，或直接调动系统的自动重写方式。
 *
    @author yangyang
    @create 2020-12-05-4:38 下午
*/public class SetTest {
//    一、set：无序存储，不可重复的数据
//       以HashSet为例说明：
//          1.无序性：不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加，而是按照数据的哈希值决定的。
//          2.不可重复性：保证添加的数据按照equals()方法判断时不能返回true，即：相同元素只能添加一个。
//     二、添加元素的过程：以HashSet为例：
//       我们向HashSet中添加元素a，首先调用元素a所在类的hashCode()方法，计算元素a的哈希值，
//       此哈希值接着通过某种算法j计算出在HashSet底层数组中的存放位置(即为：索引位置)，判断数组此位置上是否已经有元素，：
//          如果此位置上没有其他元素，则元素a添加成功。---> 情况1
//          如果此位置上有其他元素b(或以链表形式存在的多个元素)，则比较a与b的哈希值：
//              如果哈希值不相同，则a添加成功。---> 情况2
//              如果哈希值相同，则调用a所在类的equals()方法：
//                  如果equals()返回true，则a添加失败；
//                  如果equals()返回false，则a添加成功。---> 情况3
//
//    对于添加成功的情况2和情况3来说：元素 a 与 已经存在指定索引位置上数据 以链表的方式存储。
//    jdk7中：元素a放到数组中，指向原来的元素
//    jdk8中：原来的元素在数组中，指向元素a
//      总结：七上八下

    @Test
    public void Test1(){
        Set set = new HashSet();
        set.add(123);
        set.add(456);
        set.add(new User("张三",22));
        set.add(789);
        set.add("李四");
        set.add(123);
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    //LinkedHashSet的使用
    //LinkedHashSet作为HashSet的子类，在添加数据的同时，每个数据还维护两个引用，记录此数据的前一个和后一个数据
    //有点：对于频繁的遍历操作，LinkedHashSet效率要高于HashSet
    public void Test2(){
        Set set = new LinkedHashSet();
        set.add(123);
        set.add(456);
        set.add(new User("张三",22));
        set.add(789);
        set.add("李四");
        set.add(123);
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


}
