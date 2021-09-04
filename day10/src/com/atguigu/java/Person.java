package com.atguigu.java;

import java.io.Serializable;

/**
 * Person类需要满足下类要求，方可实现序列化：
 * 1.需要实现接口：Serializable
 * 2.当前类提供一个全局常量：serialVersionUID
 *
 * 3.除了当前Person类需要实现Serializable接口之外，还必须保证其内部所有属性
    也必须是可序列化的。（默认情况下，基本数据类型可序列化）
 *
 * 补充：ObjectOutputStream和ObjectInputStream不能序列化static和transient(临时的，短暂的)修饰的成员变量
 *
 * @author yangyang
 * @create 2021-03-09-11:38 上午
 */
public class Person implements Serializable {
    private String name;
    private int age;
    public static final long serialVersionUID = 423452384243L;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
}
