package com.atguigu.java1;

import org.junit.Test;

import java.util.List;

/**
 * @author yangyang
 * @create 2020-12-21-9:25 下午
 */
public class DAOTest {
    @Test
    public void Test1(){
        CustomDAO dao1 = new CustomDAO();
        dao1.add(new Customer());
        List<Customer> list = dao1.getForList(10);
        boolean remove = dao1.remove();
        dao1.update(5,new Customer());

        StudentDAO dao2 = new StudentDAO();
        dao2.add(new Student());
        dao2.getForList(10);
    }
}
