package atguigu.java;

/**
 * 创建三个窗口售票，总票数100张
 * 1.使用继承Thread的方式实现
 *
 * @author yangyang
 * @create 2020-11-03-8:46 上午
 */

class Window extends Thread {
    private static int ticket = 100;

    public Window(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "剩余票量：" + ticket);
                ticket--;
            } else if (ticket == 0) {
                System.out.println(Thread.currentThread().getName() + ":票已售尽！");
                break;
            }
        }
    }
}

public class WindowTest {

    public static void main(String[] args) {
        Window t1 = new Window("窗口1");
        Window t2 = new Window("窗口2");
        Window t3 = new Window("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}
