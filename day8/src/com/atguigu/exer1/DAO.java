package com.atguigu.exer1;

import java.util.*;

/**
 * 定义个泛型类 DAO<T>，在其中定义一个Map 成员变量，Map 的键为 String 类型，值为 T 类型。
 * <p>
 * 分别创建以下方法：
 * public void save(String id,T entity)： 保存 T 类型的对象到 Map 成员变量中
 * public T get(String id)：从 map 中获取 id 对应的对象
 * public void update(String id,T entity)：替换 map 中key为id的内容,改为 entity 对象
 * public List<T> list()：返回 map 中存放的所有 T 对象
 * public void delete(String id)：删除指定 id 对象
 *
 * @author yangyang
 * @create 2020-12-23-9:27 下午
 */

public class DAO<T> {

    private Map<String, T> map = new HashMap<>();

    //保存 T 类型的对象到 Map 成员变量中
    public void save(String id, T entity) {
        map.put(id, entity);
    }

    //从 map 中获取 id 对应的对象
    public T get(String id) {
        return map.get(id);
    }

    //替换 map 中key为id的内容,改为 entity 对象
    public void update(String id, T entity) {
        if (map.containsKey(id)) {
            map.put(id, entity);
        }
    }

    //返回 map 中存放的所有 T 对象
/*    public List<T> list(){
        Set<Map.Entry<String, T>> set = map.entrySet();
        ArrayList<T> list = new ArrayList(map.size());
        Iterator<Map.Entry<String, T>> iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, T> next = iterator.next();
            T value = next.getValue();
            list.add(value);
        }
        return list;
    }*/
    public List<T> list() {

        //错误的，不能直接将大的转换为小的
        /*Collection<T> values = map.values();
        return (List<T>) values;*/

        ArrayList<T> arrayList = new ArrayList<>();
        Collection<T> collection = map.values();
        for (T t : collection) {
            arrayList.add(t);
        }
        return arrayList;

    }

    //删除指定 id 对象
    public void delete(String id) {
        map.remove(id);
    }

}