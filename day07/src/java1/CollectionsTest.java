package java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Collections:操作 Collection、Map 的工具类
 *
 * 面试题：Collection和Collections的区别？
 *
 * @author yangyang
 * @create 2020-12-17-7:26 下午
 */
public class CollectionsTest {
    /*
    reverse(List)：反转 List 中元素的顺序
    shuffle(List)：对 List 集合元素进行随机排序
    sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
    sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
    swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换

    Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
    Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
    Object min(Collection)
    Object min(Collection，Comparator)
    int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
    void copy(List dest,List src)：将src中的内容复制到dest中
    boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换 List 对象的所有旧值
    */

    @Test
    public void Test2() {
        List list = new ArrayList();
        list.add(123);
        list.add(325);
        list.add(46);
        list.add(0);
        list.add(-65);

        List dest = Arrays.asList(new Object[list.size()]);

        Collections.copy(dest, list);//copy()是有条件的

        System.out.println(list);
        System.out.println(dest);

    /* Collections 类中提供了多个 synchronizedXxx() 方法，
        该方法可使将指定集合包装成线程同步的集合，从而可以解决
        多线程并发访问集合时的线程安全问题
    */

        List list1 = Collections.synchronizedList(list);
        //返回的list1就是线程安全的list
    }

    @Test
    public void Test1(){
        List list = new ArrayList();
        list.add(123);
        list.add(325);
        list.add(46);
        list.add(0);
        list.add(-65);

        System.out.println(list);
//        Collections.reverse(list);
//        Collections.shuffle(list);//洗牌
//        Collections.sort(list);//按照自然顺序升序排列
//        Collections.swap(list,1,2);交换
/*        Comparable max = Collections.max(list);
        System.out.println(max);
        Comparable min = Collections.min(list);
        System.out.println(min);*/
//        System.out.println(Collections.frequency(list, 123));//出现频率
        System.out.println(Collections.frequency(list, 1234));//出现频率:0

        System.out.println(list);
    }
}
