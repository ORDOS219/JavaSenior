package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Iterator迭代器的使用
 * <p>
 * 一、两个方法：
 * ①next():
 * ②hasNext():
 * 二、集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前
 * 三、内部定义了remove()方法，可在遍历的时候，删除集合中指定元素。此方法不同于集合直接调用remove()
 *     //注意：1.在调用next()之前调用remove(),会报IllegalStateException
 *     //      2.上一次调用next()之后已经调用remove(),现在又调用remove()方法，也会报IllegalStateException
 *     //  因为此时游标指向iterator的第一个元素之前，还没有下移
 * @author yangyang
 * @create 2020-11-29-5:32 下午
 */
public class IteratorTest {

    @Test
    public void Test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("ABC");
        coll.add(true);
        coll.add(new Person("小明", 20));

        Iterator iterator = coll.iterator();//创建coll的迭代器对象

/*        //方式一：不推荐使用
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());    //抛出NoSuchElementException异常
        */

/*        //方式二:不推荐使用
        for(int i = 0;i < coll.size(); i++){
            System.out.println(iterator.next());
        }*/

        //方式三：搭配使用

        //hasNext():判断是否还有下一个元素
        while (iterator.hasNext()) {
            //next():①指针先下移②将指针下移后所指集合位置上的元素返回
            System.out.println(iterator.next());
        }

    }

    @Test
    public void Test2() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("ABC");
        coll.add(true);
        coll.add(new Person("小明", 20));

        Iterator iterator = coll.iterator();//创建coll的迭代器对象

        //两种错误的实现方法：
 /*       //错误方式①：直接用iterator.next()代替iterator.hasNext()
        while((iterator.next()) != null){
            System.out.println(coll.iterator().next());//间接输出456，true，抛出NoSuchElementException异常
        }*/

        //错误方式②：使用匿名对象来迭代
        while (coll.iterator().hasNext()) {
            System.out.println(coll.iterator().next());//死循环输出123
            //每次调用iterator()方法，都会返回一个迭代器对象，这个对象是一个新的对象，指针游标指向第一个元素之前
        }

    }

    @Test
    //remove()方法测试：
    //不同于集合直接调用remove()
    //注意：1.在调用next()之前调用remove(),会报IllegalStateException
    //      2.上一次调用next()之后已经调用remove(),现在又调用remove()方法，也会报IllegalStateException
    //  因为此时游标指向iterator的第一个元素之前，还没有下移
    public void Test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("ABC");
        coll.add(true);
        coll.add(new Person("小明", 20));

        Iterator iterator = coll.iterator();//创建coll的迭代器对象

        while (iterator.hasNext()) {
            Object next = iterator.next();
            if ("ABC".equals(next))
                iterator.remove();
        }

        Iterator iterator1 = coll.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

    }

}
