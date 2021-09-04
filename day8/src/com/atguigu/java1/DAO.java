package com.atguigu.java1;

import java.util.List;

/**
 * @author yangyang
 * @create 2020-12-21-9:12 下午
 */
public class DAO<T> {//表的共性操作的DAO
    //添加一条记录
    public void add(T t){

    }
    //删除一条记录
    public boolean remove(){

        return false;
    }

    //修改一条记录
    public void update(int index,T t){

    }

    //查询一条记录
    public T getIndex(){
        return null;
    }

    //查询多条记录
    public List<T> getForList(int index){
        return null;
    }

    //获取表中的数据个数时为long；获取员工生日时为Date，具有不确定性，所以使用泛型
    public <E> E getValue(){
        return null;
    }

}
