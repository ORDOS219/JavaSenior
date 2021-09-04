package com.atguigu.java;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author yangyang
 * @create 2020-12-09-7:51 下午
 */
public class TreeSetTest {

    //使用自然排序
    @Test
    public void Test1() {
        TreeSet set = new TreeSet();
        Employee emp1 = new Employee("wangjingxv", 22, new MyDate(1998, 10, 24));
        Employee emp2 = new Employee("wangyuanyuan", 18, new MyDate(2002, 6, 3));
        Employee emp3 = new Employee("gaobihan", 30, new MyDate(1990, 8, 17));
        Employee emp4 = new Employee("liming", 23, new MyDate(1997, 6, 14));
        Employee emp5 = new Employee("baixvyang", 21, new MyDate(1999, 3, 14));

        set.add(emp1);
        set.add(emp2);
        set.add(emp3);
        set.add(emp4);
        set.add(emp5);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    //按生日日期的先后排序
    @Test
    public void Test2() {

        TreeSet set = new TreeSet(new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {

                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;

                    MyDate e1Birthday = e1.getBirthday();
                    MyDate e2Birthday = e2.getBirthday();

                    //方式三：将比较接口写到MyDate中，直接调用
                    return e1Birthday.compareTo(e2Birthday);

                    //方式一：
//                    int minusYear = e1Birthday.getYear() - e2Birthday.getYear();
//                    if (minusYear != 0) {
//                        return minusYear;
//                    } else {
//                        int minusMonth = e1Birthday.getMonth() - e2Birthday.getMonth();
//                        if (minusMonth != 0) {
//                            return minusMonth;
//                        } else {
//                            int minusDay = e1Birthday.getDay() - e2Birthday.getDay();
//                            return minusDay;
//                        }
//                    }
                    //方式二：
                    //简化判断
//                    int minusYear = e1Birthday.getYear() - e2Birthday.getYear();
//                    if (minusYear != 0) {
//                        return minusYear;
//                    }
//                    //能到这一步说明年相等
//                    int minusMonth = e1Birthday.getMonth() - e2Birthday.getMonth();
//                    if (minusMonth != 0) {
//                        return minusMonth;
//                    }
//                    return e1Birthday.getDay() - e2Birthday.getDay();

                } else {
                    throw new RuntimeException("传入的比较类型错误！");
                }
            }
        });
        Employee emp1 = new Employee("wangjingxv", 22, new MyDate(1998, 10, 24));
        Employee emp2 = new Employee("wangyuanyuan", 18, new MyDate(2002, 6, 3));
        Employee emp3 = new Employee("gaobihan", 30, new MyDate(1990, 8, 17));
        Employee emp4 = new Employee("liming", 23, new MyDate(1997, 6, 14));
        Employee emp5 = new Employee("baixvyang", 21, new MyDate(1999, 3, 14));

        set.add(emp1);
        set.add(emp2);
        set.add(emp3);
        set.add(emp4);
        set.add(emp5);

        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}