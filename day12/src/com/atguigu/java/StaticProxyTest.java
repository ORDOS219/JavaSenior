package com.atguigu.java;

/**
 * 静态代理举例：
 *
 * 特点：代理类和被代理类在编译期间，就确定下来了
 *
 * @author yangyang
 * @create 2021-03-19-5:04 下午
 */
interface ClothFactory {

    void produceCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory {

    private ClothFactory factory;//用被代理类进行实例化

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");
        factory.produceCloth();
        System.out.println("代理工厂做一些后续收尾工作");
    }

}
//被代理类
class NikeCloseFactory implements ClothFactory {
    @Override
    public void produceCloth() {

        System.out.println("NIKE工厂做一批衣服");
    }
}

public class StaticProxyTest{
        public static void main(String[] args) {
            NikeCloseFactory nike = new NikeCloseFactory();
            ProxyClothFactory clothFactory = new ProxyClothFactory(nike);
            clothFactory.produceCloth();
        }
    }

