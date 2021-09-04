package com.atguigu.java1;

/**
 * 同步方法解决 单例模式-懒汉式 存在的线程安全问题
 *
 * @author yangyang
 * @create 2020-11-04-10:50 上午
 */
public class BankTest {
}

class Bank {
    private Bank() {
    }

    private static Bank instance = null;

    //①同步方法：同步监视器为当前类：Bank.class
//    public static synchronized Bank getInstance() {
//        if (instance == null) {
//            instance = new Bank();
//        }
//        return instance;
//    }

    //②同步代码块：同步监视器显式声明为当前类：Bank.class
//    public static Bank getInstance() {   //效率差
//        synchronized (Bank.class) {
//            if (instance == null) {
//                instance = new Bank();
//            }
//            return instance;
//        }
//    }

    //③同步代码块：同步监视器显式声明为当前类：Bank.class  //效率高 不必每个都进入判断
    public static Bank getInstance() {
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}
