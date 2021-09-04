package java1;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/**
 * 涉及到两种排序：
 *      1.自然排序
 *      2.定制排序
 *
 * @author yangyang
 * @create 2020-12-17-5:18 下午
 */
public class TreeMapTest {
    @Test
    //自然排序
    public void Test(){

        TreeMap map = new TreeMap();
        //向TreeMap中添加 key-value，要求key必须是由同一个类创建的对象
        //因为要按照key进行排序：自然排序、定制排序

        User u1 = new User("wangjingxv",22);
        User u2 = new User("wangyuanyuan",20);
        User u3 = new User("gaobihan",23);
        User u4 = new User("liming",23);
        User u5 = new User("wanghao",20);
        map.put(u1,89);
        map.put(u2,88);
        map.put(u3,78);
        map.put(u4,75);
        map.put(u5,80);

        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    //定制排序
    public void Test2(){

        //向TreeMap中添加 key-value，要求key必须是由同一个类创建的对象
        //因为要按照key进行排序：自然排序、定制排序

        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    User user1 = (User) o1;
                    User user2 = (User) o2;
                    return Integer.compare(user1.getAge(), user2.getAge());
                }
                throw new RuntimeException("比较类型不匹配！");
            }
        });
        User u1 = new User("wangjingxv",22);
        User u2 = new User("wangyuanyuan",20);
        User u3 = new User("gaobihan",23);
        User u4 = new User("liming",24);
        User u5 = new User("wanghao",21);
        map.put(u1,89);
        map.put(u2,88);
        map.put(u3,78);
        map.put(u4,75);
        map.put(u5,80);

        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
