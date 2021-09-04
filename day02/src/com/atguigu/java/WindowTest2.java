package com.atguigu.java;

/**
 * 创建三个窗口售票，总票数100张
 * 1.使用继承Thread的方式实现
 *  在继承Thread类创建多线程的方式中，慎用this充当同步监视器，可以考虑当前类充当同步监视器。
 * @author yangyang
 * @create 2020-11-03-8:46 上午
 */

class Window2 extends Thread {
    private static int ticket = 100;
//    Object obj = new Object();

    public Window2(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
//            synchronized (obj) {  //方式一：错误，obj不是唯一一个对象
//              synchronized(this){   //方式二：错误，this不是唯一一个对象，代表着t1,t2,t3三个对象
                synchronized (Window2.class){   //方式三：可以用Window2.class来代替当前对象 类只会加载一次
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "剩余票量：" + ticket);
                    ticket--;
                } else if (ticket == 0) {
                    System.out.println(Thread.currentThread().getName() + ":票已售尽！");
                    break;
                }
            }
        }

    }
}


public class WindowTest2 {

    public static void main(String[] args) {
        Window2 t1 = new Window2("窗口1");
        Window2 t2 = new Window2("窗口2");
        Window2 t3 = new Window2("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}