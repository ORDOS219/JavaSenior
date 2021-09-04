package com.atguigu.java2;

/**
 * 线程通信的例子：使用两个线程打印1-100.线程1，线程2交 替打印
 *
 * 涉及到的通信方法：
 *  wait():一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器
 *  notify():一旦执行此方法，就会唤醒一个被wait()的线程。如果有多个线程被wait(),就唤醒优先级最高的线程
 *  notifyAll():一旦执行此方法，就会唤醒所有被wait()的线程。
 *
 *  说明：
 *  1.wait(),notify(),notifyAll()三个方法都只能用在同步代码块或同步方法中。
 *  2.wait(),notify(),notifyAll()三个方法的调用者必须是同步代码块或同步方法中的同步监视器。
 *      否则，会出IllegalMonitorStateException异常
 *  3.wait(),notify(),notifyAll()三个方法是定义在java.lang.Object类中。
 *
 *
 * 面试题：sleep() 和 wait()方法的异同？
 *  相同点：一旦执行方法，都可以使得当前的线程进入阻塞状态
 *  不同点：1）两个方法声明的位置不同：Thread类中声明sleep(),Object类中声明wait()
 *         2)调用的要求不同：sleep()可以在任何需要的场景下调用。wait()必须使用在同步代码块或同步方法中
 *         3)关于是否释放同步监视器：如果两个方法都使用在同步代码块或同步方法中，sleep()不释放同步监视器，wait()会释放同步监视器
 *
 *
 * @author yangyang
 * @create 2020-11-05-10:36 上午
 */
class Number implements Runnable {

    int num = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notify();
                if (num <= 100) {
                    System.out.println(Thread.currentThread().getName() + "打印 ：" + num);
                    num++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}

public class CommunicationTest {
    public static void main(String[] args) {
        Number numb = new Number();
        Thread t1 = new Thread(numb);
        Thread t2 = new Thread(numb);
        t1.setName("线程1 ：");
        t2.setName("线程2 ：");
        t1.start();
        t2.start();
    }
}
