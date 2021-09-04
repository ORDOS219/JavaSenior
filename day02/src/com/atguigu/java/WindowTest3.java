package com.atguigu.java;

/**
 * 使用同步方法解决实现Runnable接口存在的线程安全问题
 *  可以将方法单独声明，加关键字synchronized，最后在调用方法
 *
 * 关于同步方法的总结：
 *  1.同步方法仍然设计到同步监视器，只是不需要我们显式声明
 *  2.非静态方法的同步监视器：this
 *    静态方法的同步监视器：当前类本身
 *
 * @author yangyang
 * @create 2020-11-04-8:52 上午
 */
class Window3 implements Runnable {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            sell();
        }
    }

    public synchronized void sell() {   //同步监视器默认为this
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "售票： " + ticket);
            ticket--;
        }
    }
}

public class WindowTest3 {
    public static void main(String[] args) {

        Window3 w = new Window3();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        Thread t4 = new Thread(w);

        t1.setName("窗口 1 ");
        t2.setName("窗口 2 ");
        t3.setName("窗口 3 ");
        t4.setName("窗口 4 ");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}