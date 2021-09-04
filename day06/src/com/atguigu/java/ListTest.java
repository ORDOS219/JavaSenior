package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**基于Collection,List中的方法测试
 *
 *      list.add(int index, Object ele);    向指定索引位置添加元素
 *      list.add(list1);    将list1作为一个[]对象添加到list中
 *      list.addAll(List list);      将List对象中的所有元素依次添加到list中
 *      Object.get(int index);      获得指定位置的元素
 *      list.indexOf(Object ele);返回obj第一次出现的位置。类似于字符串String中的indexOf()。
 *      list.lastIndexOf(Object ele);返回element最后出现的位置
 *      remove(int index);移除指定位置上的元素 重载了Collection中的remove()方法，所以既可以以对象移除，也可以以索引移除
 *      list.set(int index ,Object ele);  将指定位置的元素设置为element
 *      List subList(int fromIndex, int toIndex);返回从formIndex到toIndex范围内的子list，左闭右开
 *
 * 总结：常用方法
 * 增：add(Object ele)
 * 删：remove(int index) /remove(Object ele)
 * 改：set(int index, Object obj)
 * 查：get(int index) /indexOf(Object ele) /lastIndexOf(Object ele)
 * 插：add(int index, Object ele)
 * 长度：size()
 * 遍历：①Iterator ②增强for()循环 ③普通循环
 *
 * @author yangyang
 * @create 2020-12-04-10:52 下午
 */
public class ListTest {

    @Test
    //list遍历测试
    public void Text3(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(new Person("小王",22));
        list.add(123);
        //方式一：Iterator遍历
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("***********");
        //方式二：增强for()循环
        for(Object i : list){
            System.out.println(i);
        }
        System.out.println("***********");

        //方式三：普通循环
        for(int i = 0;i < list.size();i++){
            System.out.println(list.get(i));
        }
    }

    @Test
    public void Test2(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(new Person("小王",22));
        list.add(123);

        //list.indexOf(Object obj);返回obj第一次出现的位置。类似于字符串String中的indexOf()。

        int indexOf = list.indexOf(123);
        int indexOf1 = list.indexOf(234);
        System.out.println(indexOf);//0
        System.out.println(indexOf1);//-1 不存在返回-1

        //list.lastIndexOf(Object obj);返回obj最后出现的位置

        int lastIndexOf = list.lastIndexOf(123);
        System.out.println(lastIndexOf);  //3

        //remove(int index);移除指定位置上的元素 ,重载了Collection中的remove()方法，所以既可以以对象移除，也可以以索引移除

        System.out.println(list);   //[123, 456, Person{name='小王', age=22}, 123]
        Object remove = list.remove(0);
        System.out.println(remove);   //123
        System.out.println(list);    //[456, Person{name='小王', age=22}, 123]
//        Object remove = list.remove(123);   要想以对象形式remove()list中元素，可以new一个包装类的对象,见下
//        System.out.println(remove);   java.lang.IndexOutOfBoundsException: Index 123 out of bounds for length 4

/*        //要想以对象形式remove()list中元素，可以new一个包装类的对象
        System.out.println(list);   //[123, 456, Person{name='小王', age=22}, 123]
        boolean remove = list.remove(new Integer(123));
        System.out.println(remove); //true
        System.out.println(list);   //[456, Person{name='小王', age=22}, 123]*/


        //list.set(int index ,Object obj);  将指定位置的元素设置为obj

        Object set = list.set(1,789);
        System.out.println(list);//[456, 789, 123]

        //List subList(int fromIndex, int toIndex);返回从formIndex到toIndex范围内的子list，左闭右开

        List subList = list.subList(0, 2);
        System.out.println(subList);//[456, 789]

    }

    @Test
    public void Test1(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(new Person("小王",22));
        list.add(123);
        System.out.println(list);

        //list.add(int index, Object obj);向指定索引位置添加元素

        list.add(2,new Person("小邓",21));
        System.out.println(list);

        //list.addAll(List list);将List对象中的所有元素依次添加到list中

        List list1 = Arrays.asList(1, 2, 3);
//        list.addAll(list1);
//        list.add(list1);//将list1作为一个[]对象添加到list中
        System.out.println(list.size());//5+3
        System.out.println(list);//[123, 456, Person{name='小邓', age=21}, Person{name='小王', age=22}, 123, 1, 2, 3]

        //Object.get(int index);获得指定位置的元素

        System.out.println(list.get(2));

    }

}
