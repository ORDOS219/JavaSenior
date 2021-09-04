package atguigu.exer;

/**
 * 创建两个分线程，让一个线程遍历100以内的偶数，一个线程遍历100以内的奇数
 * 方式一：创建两个类
 * 方式二：创建匿名子类
 *
 * @author yangyang
 * @create 2020-11-02-8:28 下午
 */

class MyThreada extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " 遍历100以内的偶数: " + i);
            }
        }
    }
}

class MyThreadb extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + " 遍历100以内的奇数: " + i);
            }
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
//方式一：创建两个类
//        MyThreada t1 = new MyThreada();
//        MyThreadb t2 = new MyThreadb();
//        t1.start();
//        t2.start();

//方式二：创建匿名子类的方式实现两个线程
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + " 遍历100以内的偶数: " + i);
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + " 遍历100以内的奇数: " + i);
                    }
                }
            }
        }.start();
    }
}
