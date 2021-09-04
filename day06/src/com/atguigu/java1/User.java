package com.atguigu.java1;

/**
 * @author yangyang
 * @create 2020-12-05-8:28 下午
 */
public class User implements Comparable {
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        //姓名由小到大，年龄由小到大
        if (o instanceof User) {
            User user1 = (User) o;
//            return this.name.compareTo(user1.name);   //只比较姓名大小
            int compare = -this.name.compareTo(user1.name);
            if (compare != 0) {   //说明两个值不相等
                return compare;
            } else {
                return Integer.compare(this.age, user1.age);
            }
        } else {
            throw new RuntimeException("比较类型错误！");
        }
    }
}
