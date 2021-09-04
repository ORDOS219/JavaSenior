package com.atguigu.java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三：Lock锁  ---JDK5.0新增
 *
 * 面试题：synchronized 和 lock 有什么异同？
 * 相同：二者都可以解决线程安全问题
 * 不同：synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器(锁)
 *      lock需要手动的启动同步（lock()）,手动实现结束同步（unlock()）
 *
 *      优先使用顺序：Lock ->同步代码块 (已经进入方法体，分配了相应的资源) -> 同步方法 (在方法体之外)
 *面试题：如何解决线程安全问题？有几种方式
 *两种：1.同步监视器synchronized （①同步方法 ②同步代码块）
 *     2.lock锁
 *
 * @author yangyang
 * @create 2020-11-04-9:29 下午
 */
class Window implements Runnable {
    private int ticket = 100;
    //1.实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true) {
            try {
                //2.调用锁定方法lock()
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "：售票，票号为： " + ticket);
                    ticket--;
                } else {
                    break;
                }
            }finally{
                //3.调用解锁方法：unlock()
                lock.unlock();
            }
        }
    }
}

public class LockTest {
    public static void main(String[] args) {

        Window w = new Window();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}
