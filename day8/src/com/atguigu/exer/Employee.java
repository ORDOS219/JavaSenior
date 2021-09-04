package com.atguigu.exer;

/**
 * @author yangyang
 * @create 2020-12-09-7:33 下午
 */
public class Employee implements Comparable<Employee>{

    private String name;
    private int age;
    private MyDate birthday;

    public Employee() {
    }

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
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

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    //有泛型时的写法
    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.getName());
    }

/*    @Override
    //没有指明泛型时的写法
    public int compareTo(Object o) {
        if(o instanceof Employee){
            Employee emp = (Employee)o;
            return this.getName().compareTo(emp.getName());
        }else{
            throw new RuntimeException("比较类型错误！");
        }
    }*/

}
