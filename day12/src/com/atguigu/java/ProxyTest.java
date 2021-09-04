package com.atguigu.java;

/**
 * 动态代理的举例：
 *
 *
 *
 * @author yangyang
 * @create 2021-03-19-5:43 下午
 */
interface Human{
    String Belife();

    void eat(String food);
}
//被代理类
class SupperMan implements Human{

    @Override
    public String Belife() {
        return "我可以飞";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}
/*
* 要想实现动态代理*/
public class ProxyTest {
}
