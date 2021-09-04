package atguigu.java;

/**
 * 多线程的创建：方式一：继承与Thread类
 * 1.创建一个继承于Thread类的子类
 * 2.重写Thread中的run()方法->将此线程执行的操作声明在run（）方法中
 * 3.创建Thread类的子类的对象
 * 4.通过此对象调用start()
 *     start()的作用：
 *        1.启动当前线程
 *        2.调用当前线程的run()
 *
 * @author yangyang
 * @create 2020-11-02-7:24 下午
 */
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }
    }
}

class MyThreada extends Thread{
    public void run() {
        for(int i = 0;i < 10;i++){

            System.out.println(Thread.currentThread().getName() + "这是我创建的第三个线程的第" + i + "个");
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        //创建Thread类的子类对象
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThreada t3 = new MyThreada();
        t1.start();
        //不能通过对象直接调用run()的方式来创建线程
//        t1.run();
        t2.start(); // 再启动一个线程需要重新创建一个线程的对象
        t3.start();
        //如下操作仍然是在main线程中执行的
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + i + "****");
            }
        }

    }

}
