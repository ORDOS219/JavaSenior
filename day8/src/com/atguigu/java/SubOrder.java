package com.atguigu.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangyang
 * @create 2020-12-21-5:10 下午
 */
public class SubOrder extends Order<Integer> {//SubOrder:不是泛型类
    public static <E> List<E> copyFromArrayToList(E[] arr) {//泛型方法与所在类是不是泛型无关
        ArrayList<E> list = new ArrayList<>();
        for (E a : arr) {
            list.add(a);
        }
        return list;
    }

}
