package java1;

import org.junit.Test;

import java.util.*;

/**
 * 一、Map的实现类的结构
 * |----Map:双列数据存储key-value对的数据  ----类似于高中时的函数
 *      |----HashMap:作为Map的主要实现类；线程不安全，效率高；可以存储null的key和value
 *          |----LinkedHashMap:保证在遍历map元素时，可以按照添加的顺序进行遍历
 *                             原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个元素和后一个元素。
 *                             对于频繁的遍历操作，LinkedHashMap的效率要高于HashMap。
 *      |----TreeMap:保证按照添加的key-value对顺序进行排序，实现排序遍历。此时考虑key的自然排序或定制排序底层使用红黑树。
 *      |----HashTable:作为Map的古老实现类；线程安全，效率低；不可以存储null的key和value
 *          |----Properties:常用来处理配置文件。key和value都是String类型。
 *
 *
 *      HashMap的底层：数组+链表 （jdk 7及之前）
 *                    数组+链表+红黑数（jdk 8）
 *
 * 面试题：
 *      1.HashMap 的底层实现原理？
 *      2.HashMap 和 Hashtable 的异同？
 *      3.CurrentHashMap 和 Hashtable 的异同？
 *
 * 二、Map结构的理解
 *      Map中的key：无序的、不可重复的，使用set存储所有的key ---> key所在的类要重写equals() 和 hashCode()
 *      Map中的value：无序的、可重复的，使用Collection存储所有的value ---> value所在的类要重写 equals()
 *      一个键值对：key-value 构成一个Entry对象。
 *      Map中的entry：无序的、不可重复的；使用set存储所有的entry
 *
 * 三、HashMap的底层实现原理？(以jdk7说明)
 *  HashMap map = new HashMap():
 *      在实例化之后，底层创建了长度为16的一位数组 Enter[] table。
 *      ...可能已经执行过多次 put() ...
 *      map.put(key1,value1):
 *         首先，调用 key1 所在类的hashCode()计算 key1 的哈希值，此哈希值经过某种算法计算以后，得到在Enter数组中的存放位置
 *         如果此位置上的数据为空，此时的 key1-value1 添加成功。--- 情况一
 *         如果此位置上的数据不为空（一位这此位置上存在一个或多个数据（以链表的形式存在)),比较key1和已经存在的一个或多个数据的哈希值：
 *            如果 key1 的哈希值与已经存在的数据的哈希值都不相同，则 key1-value1 添加成功； --- 情况二
 *            如果 key1 的哈希值与已经存在的某一个数据(key2-value2)的哈希值相同,继续比较：调用key1所在类的equals()：
 *              如果equals()返回false：此时 key1-value1 添加成功； --- 情况三
 *              如果equals()返回true：使用 value1 替换 value2。
 *
 *       补充：关于情况二和情况三：此时 key1-value1 和 原来的数据 以链表的方式存储。
 *
 *       在不断的添加过程中，会涉及到扩容问题：当超出临界值（且要存放的位置非空）时，默认的扩容方式：扩容为原来的两倍，并将原有的数据复制过来
 *
 *      jdk8 相较于 jdk7 在底层实现方面的不同：
 *      1.new HashMap();底层没有创建长度为16的数组
 *      2.jdk8 的底层数组为Node[],而不是Enter[]
 *      3.首次调用put()方法时，底层创建长度为16的数组
 *      4.jdk7 的底层只有：数组 + 链表；jdk8 中底层为：数组 + 链表 + 红黑数。
 *          使用红黑数的情况：
 *              当数组的某一索引位置上的元素以链表形式存在的数据个数>8 且 当前数组的长度>64时，
 *              此时索引位置上的所有数据改为使用红黑数存储。
 *
 *        DEFAULT_INITIAL_CAPACITY : HashMap的默认容量，16
 *        DEFAULT_LOAD_FACTOR：HashMap的默认加载因子：0.75
 *        threshold：扩容的临界值，=容量*填充因子：16 * 0.75 => 12
 *        TREEIFY_THRESHOLD：Bucket中链表长度大于该默认值，转化为红黑树:8
 *        MIN_TREEIFY_CAPACITY：桶中的Node被树化时最小的hash表容量:64
 *
 *
 * 四、LinkedHashMap的底层实现原理（了解）
 *    源码中：
 *     static class Entry<K,V> extends HashMap.Node<K,V> {
 *         Entry<K,V> before, after;//能够记录添加的元素的先后顺序
 *         Entry(int hash, K key, V value, Node<K,V> next) {
 *            super(hash, key, value, next);
 *         }
 *      }
 *
 *   五、Map中定义的方法：
 *   添加、删除、修改操作：
 *      Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
 *      void putAll(Map m):将m中的所有key-value对存放到当前map中
 *      Object remove(Object key)：移除指定key的key-value对，并返回value
 *      void clear()：清空当前map中的所有数据
 *
 *   元素查询的操作：
 *      Object get(Object key)：获取指定key对应的value
 *      boolean containsKey(Object key)：是否包含指定的key
 *      boolean containsValue(Object value)：是否包含指定的value
 *      int size()：返回map中key-value对的个数
 *      boolean isEmpty()：判断当前map是否为空
 *      boolean equals(Object obj)：判断当前map和参数对象obj是否相等
 *
 *   元视图操作的方法：
 *      Set keySet()：返回所有key构成的Set集合
 *      Collection values()：返回所有value构成的Collection集合
 *      Set entrySet()：返回所有key-value对构成的Set集合
 *
 * @author yangyang
 * @create 2020-12-14-8:23 下午
 */
public class MapTest {

    @Test
    public void Test1(){
//        Map h = new HashMap();
        Map h  = new LinkedHashMap();
        h.put("wanghao",123);
        h.put("zhangyinghao",456);
        System.out.println(h);
    }
    /*
     *     添加、删除、修改操作：
     *      Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
     *      void putAll(Map m):将m中的所有key-value对存放到当前map中
     *      Object remove(Object key)：移除指定key的key-value对，并返回value
     *      void clear()：清空当前map中的所有数据*/
    @Test
    public void Test2(){
        Map map = new HashMap();
        map.put("zhansan",18);
        map.put("lisi",19);
        map.put("wangjingxv",22);
        map.put("zhansan",21);
        System.out.println(map);//{lisi=19, wangjingxv=22, zhansan=21}
        System.out.println("*****");
        Map map1 = new HashMap();
        map1.put("wangyuanyuan",19);
        map1.put("gaobihan",30);
        map1.put("wanghao",19);
        map.putAll(map1);
        System.out.println(map);//{lisi=19, wangyuanyuan=19, wangjingxv=22, wanghao=19, gaobihan=30, zhansan=21}
        System.out.println("*****");
        Object lisi = map.remove("lisi");
        System.out.println(lisi);//19
        System.out.println(map);//{wangyuanyuan=19, wangjingxv=22, wanghao=19, gaobihan=30, zhansan=21}

        System.out.println("*****");
        map1.clear();
        System.out.println(map1);//{}
        System.out.println(map);//{wangyuanyuan=19, wangjingxv=22, wanghao=19, gaobihan=30, zhansan=21}
        map.clear();
        System.out.println(map);//{}
    }
    /*
     *   元素查询的操作：
     *      Object get(Object key)：获取指定key对应的value
     *      boolean containsKey(Object key)：是否包含指定的key
     *      boolean containsValue(Object value)：是否包含指定的value
     *      int size()：返回map中key-value对的个数
     *      boolean isEmpty()：判断当前map是否为空
     *      boolean equals(Object obj)：判断当前map和参数对象obj是否相等*/
    @Test
    public void Test3(){
        Map map = new HashMap();

        Map map1 = new HashMap();

        map1.put("zhansan",18);
        map1.put("lisi",19);
        map1.put("wangjingxv",22);
//        map1.put("zhansan",21);

        map.put("zhansan",18);
        map.put("lisi",19);
        map.put("wangjingxv",22);
        map.put("zhansan",21);
        Object wjx = map.get("wangjingxv");
        System.out.println(wjx);
        Object wjx1 = map.get("wangjingxvvvv");
        System.out.println(wjx1);//false

        System.out.println("*****");
        boolean existWjx1 = map.containsKey("wangjingxv");
        System.out.println(existWjx1);//true
        boolean exixtWjx2 = map.containsKey("wangjingxi");
        System.out.println(exixtWjx2);//false
        System.out.println("*****");
        boolean b = map.containsValue(22);
        System.out.println(b);//true
        System.out.println(map.size());
        System.out.println(map.isEmpty());//false
//        System.out.println(map.getClass());
        boolean equals = map.equals(map1);
        System.out.println(equals);
    }
    /*
     *   元视图操作的方法：
     *      Set keySet()：返回所有key构成的Set集合
     *      Collection values()：返回所有value构成的Collection集合
     *      Set entrySet()：返回所有key-value对构成的Set集合*/
    @Test
    public void Test4(){
        Map map = new HashMap();
        map.put("zhansan",18);
        map.put("lisi",19);
        map.put("wangjingxv",22);
        map.put("zhansan",21);

        System.out.println(map);

        //遍历map中的 key 和 value

        Set set = map.keySet();
        Iterator key = set.iterator();
        while (key.hasNext()){
            System.out.print("key:" + key.next() + "  ");
        }
        System.out.println();
        Collection values = map.values();
        Iterator value = values.iterator();
        while(value.hasNext()){
            System.out.print("value:" + value.next() + "  ");
        }

        System.out.println("****");

        //方式一：自己拼凑出来
        Set keySet = map.keySet();
        Iterator iterator = keySet.iterator();
        while(iterator.hasNext()){
            Object key1 = iterator.next();
            Object value1 = map.get(key1);
            System.out.println(key1 + " === " + value1);
        }
        System.out.println("****");
        //方式二：调用方法
        Set set1 = map.entrySet();
        Iterator iterator1 = set1.iterator();
        while(iterator1.hasNext()){
            Object obj = iterator1.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
//            System.out.println(iterator1.next());
        }
        System.out.println("****");


    }
}