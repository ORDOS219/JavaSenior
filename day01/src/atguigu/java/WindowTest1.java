package atguigu.java;

/**
 * 创建三个窗口售票，总票数100张
 * 使用Runnable接口的方式来实现
 * 存在线程安全
 *
 * @author yangyang
 * @create 2020-11-03-10:39 上午
 */
class MThread implements Runnable {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "售票： " + ticket);
                ticket--;
            } else if (ticket == 0) {
                System.out.println("票已售尽！");
                break;
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
