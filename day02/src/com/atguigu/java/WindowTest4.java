package com.atguigu.java;

/**
 * @author yangyang
 * @create 2020-11-04-9:45 上午
 */
class Window4 extends Thread {
    private static int ticket = 100;
//    Object obj = new Object();

    public Window4(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            sell();
        }
    }

//    public synchronized void sell() { //此时的同步监视器还是默认为this，有三个对象，t1,t2,t3
    public static synchronized void sell() {    //使用static关键字，让方法成为静态方法；同步监视器：Window4.class
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "剩余票量：" + ticket);
            ticket--;
        }
    }
}

public class WindowTest4 {

    public static void main(String[] args) {
        Window4 t1 = new Window4("窗口1:");
        Window4 t2 = new Window4("窗口2:");
        Window4 t3 = new Window4("窗口3:");

        t1.start();
        t2.start();
        t3.start();
    }
}