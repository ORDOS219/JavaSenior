package com.atguigu.exer1;

import org.junit.Test;

import java.util.List;

/**
 * 创建 DAO 类的对象， 分别调用其 save、get、update、list、delete 方法来操作 User 对象，
 * 使用 Junit 单元测试类进行测试。
 *
 * @author yangyang
 * @create 2020-12-23-11:20 下午
 */
public class DAOTest {

    @Test
    public void test() {
        DAO<User> dao = new DAO<>();
        dao.save("1001", new User(1001, 20, "zhangsan"));
        dao.save("1002", new User(1002, 18, "lisi"));
        dao.save("1003", new User(1003, 21, "wangwu"));

        dao.get("1002");

        dao.update("1001", new User(1001, 22, "wangjingxv"));

        List<User> list = dao.list();
//        System.out.println(list);
        list.forEach(System.out::println);
        dao.delete("1002");

        List<User> list1 = dao.list();
        list1.forEach(System.out::println);

    }
}
