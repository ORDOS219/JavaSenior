package com.atguigu.java2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author yangyang
 * @create 2020-12-23-3:25 下午
 */
public class GenericTest {
    /**
        1、泛型在继承方面的体现

        虽然 A 是 B 的父类，但是 G<A> 与 G<B> 二者不具备子父类关系，二者是并列关系

        补充：A 是 B 的父类，并且 A<G> 是 B<G> 的父类，多态性的表现变小了

     */
    @Test
    public void test1(){
        Object[] obj = new Object[10];
        String[] str = new String[5];
        obj = str;

        /*编译不通过*/
//        Date date = new Date();
//        str = date;
        List<Object> list = null;
        List<String> str1 = null;
        /*编译不通过*/
//        list = str1;  //此时的list和str1的是两个并列的类型，不具有子父类关系，相当于将Date型对象赋值给String型对象

    }
    /**
        2.通配符的使用

            通配符：?

            类A 是 类B 的父类，G<A> 与 G<B> 不是子父类关系，G<A> 与 G<B>的共同父类为 G<?>

     */
    @Test
    public void test2(){

        List<Object> list1 = null;
        List<String> list2 = null;
        List<?> list = null;

        list = list1;
        list = list2;//都可以赋给共同父类

        show(list);

    }
    public void show(List<?> list){
        Iterator<?> iterator = list.iterator();
        while(iterator.hasNext()){

            Object next = iterator.next();//通过Object来接收通配符下的对象的值

            System.out.println(next);
        }
    }
    @Test
    public void test3(){
        List<Object> list1 = null;
        List<String> list2 = null;
        List<String> list3 = new ArrayList<>();

        List<?> list = null;

        list3.add("AA");
        list3.add("BB");
        list3.add("CC");

        list = list3;
        //添加（写入）：对于List<?>,就不能对其内部添加数据
        //除了添加 null之外
        /*
            list.add("DD");
            list.add('?');
        */
        list.add(null);

        //获取（读取）：允许读取数据，读取的数据类型为Object。
        Object o = list.get(0);
        System.out.println(o);

        Iterator<?> iterator = list.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);

        }
    }
    /**
    * 有限制条件的通配符的使用（多态的体现）
    *   ? extends A:
     *          G<? extends A>可以作为G<A> 和 G<B>的父类，其中 B 是 A 的子类
     *  ? super A:
     *          G<? super A>可以作为G<A> 和 G<B>的父类，其中 B 是 A 的子类
    *
    * */
    @Test
    public void test4(){
        List<? extends Person> list1 = null;//extends == (<=)
        List<? super Person> list2 = null;//extends == (>=)
        List<Student> list3 = null;
        List<Person> list4 = null;
        List<Object> list5 = null;

        list1 = list3;
        list1 = list4;
//        list1 = list5;编译失败 需要 <= Person
//        list2 = list3;编译失败 需要 >= Person
        list2 = list4;
        list2 = list5;

        //读数据
        list1 = list4;
        Object o1 = list1.get(0);//可以拿 >= Person的类来承接
        Person p1 = list1.get(0);

        list2 = list4;
//        Person p2 = list2.get(0);//只能拿Object承接
        Object o3 = list2.get(0);


        //添加（写入）
        //list1.add(new Student()); 编译不通过，因为可能比Student还小

        list2.add(new Person());
        list2.add(new Student());

    }
}
