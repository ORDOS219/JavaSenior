package com.atguigu.java;

/**
 * 创建三个窗口售票，总票数100张
 * 使用Runnable接口的方式来实现
 *
 * 在Java中，我们通过同步机制解决线程的安全问题。
 *
 * 方式一：同步代码块
 *  synchronized(同步监视器){
 *      //需要被同步的代码
 *  }
 *  说明：1.操作共享数据的代码即为需要被同步的代码（不能多也不能少）
 *       2.共享数据：多个线程共同操作的变量。如：ticket就是共享数据
 *       3.同步监视器，俗称：锁 任何一个类的对象，都可以充当锁。
 *              要求：多个线程必须要共用同一把锁
 *              补充：在实现Runnable接口创建多线程方式中我们可以"考虑"使用this充当同步监视器。
 *                    在继承Thread类创建多线程的方式中，慎用this充当同步监视器，可以考虑当前类充当同步监视器。
 *
 *方式二：同步方法
 *
 *
 *
 * 好处：同步的方式解决了线程的安全问题
 * 局限性：操作同步代码时只能有一个线程参与，其他线程等待，相当于是一个单线程的过程，效率低。
 * @author yangyang
 * @create 2020-11-03-10:39 上午
 */
class MThread implements Runnable {
    private static int ticket = 100;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
//            synchronized(obj) {
                synchronized (this){    //方式二：使用this充当同步监视器
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "售票： " + ticket);
                    ticket--;
                } else if (ticket == 0) {
                    System.out.println(Thread.currentThread().getName() + ": 票已售尽！");
                    break;
                }
            }
        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        MThread mtread = new MThread();

        Thread t1 = new Thread(mtread);
        Thread t2 = new Thread(mtread);
        Thread t3 = new Thread(mtread);
        Thread t4 = new Thread(mtread);

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