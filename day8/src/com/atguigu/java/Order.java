package com.atguigu.java;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义泛型类
 *
 * @author yangyang
 * @create 2020-12-21-5:01 下午
 */
public class Order<T> {
    String orderName;
    int orderId;
    //类的内部结构就可以使用类的泛型
    T orderT;

    public Order() {//声明构造器时不要加泛型，实例化时候再加
//        T[] arr = new T[10];//编译不通过
        T[] arr = (T[]) new Object[10];
    }

    public Order(String orderName, int orderId, T orderT) {//声明构造器时不要加泛型，实例化时候再加
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    //如下的三个方法都不是泛型方法
    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }
    //静态方法中不能使用泛型，因为泛型的类型是在类实例化的时候才确定的，静态方法中无法确定
/*
    public static void show(T orderT) {
        System.out.println(orderT); //泛型方法在调用时，指明泛型参数的类型
    }
*/
    //异常类不能是泛型
/*    public void show(){
        try{
            //编译不通过
        }catch(T t){

        }
    }*/
//    泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系
//    换句话说，泛型方法所属的类是不是泛型类都无所谓
//    泛型方法，可以声明为静态的，原因：泛型参数是在调用方法时确定的，并非在实例化类时确定的
    public static <E> List<E> copyFromArrayToList(E[] arr) {
        ArrayList<E> list = new ArrayList<>();
        for (E a : arr) {
            list.add(a);
        }
        return list;
    }
}