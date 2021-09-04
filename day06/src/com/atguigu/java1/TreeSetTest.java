package com.atguigu.java1;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * TreeSet测试
 *
 * @author yangyang
 * @create 2020-12-06-11:52 上午
 */
public class TreeSetTest {
    /*
     * 1.想TreeSet中添加的数据，只能是相同类的对象
     * 2.两种排序方式：自然排序(实现Comparable接口) 和 定制排序(Comparator)
     *
     * 3.自然排序中，比较两个对象是否相同的标准为：compareTo()返回0，不再是equals().
     * 4.定制排序中，比较两个对象是否相同的标准为：compare()返回0，不再是equals().
     * */
    public void Test1() {
        TreeSet treeSet = new TreeSet();
        //失败：只能添加相同类的对象
//        treeSet.add(123);
//        treeSet.add(1024);
//        treeSet.add(456);
//        treeSet.add(789);
//        treeSet.add("abc");

        //举例一
//        treeSet.add(123);
//        treeSet.add(28);
//        treeSet.add(-12);
//        treeSet.add(34);
//        treeSet.add(123);   // -12 28 34 123

        //举例二
//        treeSet.add("abc");
//        treeSet.add("bcd");
//        treeSet.add("yangyang");
//        treeSet.add("hello");
//        treeSet.add("world");   //abc bcd hello world yangyang

        //举例三

        treeSet.add(new User("王景煦", 22));
        treeSet.add(new User("杨阳", 22));
        treeSet.add(new User("王美丽", 18));
        treeSet.add(new User("高碧晗", 21));
        treeSet.add(new User("杨阳", 20));

        Iterator iterator = treeSet.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    @Test
    public void Test2() {
        //按照年龄从大到小排列
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User user1 = (User) o1;
                    User user2 = (User) o2;
                    return Integer.compare(user1.getAge(), user2.getAge());//根据年龄由大到小排序
                } else {
                    throw new RuntimeException("比较类型错误！");
                }
            }
        };
        TreeSet treeSet = new TreeSet(com);
        treeSet.add(new User("王景煦", 22));
        treeSet.add(new User("王美丽", 18));
        treeSet.add(new User("高碧晗", 21));
        treeSet.add(new User("杨阳", 22));
        treeSet.add(new User("杨阳", 20));

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
