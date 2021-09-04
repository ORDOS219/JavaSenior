package atguigu.java;

/**
 * Thread中一些常用方法的测试：
 * 1.start():启动当前线程；调用当前线程的run()方法
 * 2.通常需要重写Thread类中的run()方法，将创建的线程执行的操作声明在此方法中
 * 3.currentThread():静态方法，返回执行当前代码的线程
 * 4.getName()：获取当前线程的名字
 * 5.setName():设置当前线程的名字
 * 6.yield():释放当前CPU的执行权，但是下一刻还可能分配到CPU的执行权
 * 7.join():在线程A中调用线程B的join()方法，此时A进入阻塞状态，直到线程B完全执行完以后线程A才结束阻塞状态，等待CPU分配执行权
 * 8.stop()：已过时。当执行此方法时，强制结束当前线程。
 * sleep(long millitime):让当前进程"睡眠"指定的millitime毫秒。在指定的millitime毫秒时间内，当前线程是阻塞状态
 * 10.isAlive():判断当前线程是否存活
 *
 * 线程的优先级：
 * 1.
 * MAX_PRIORITY:10
 * MIN_PRIORITY:1
 * NORM_PRIORITY:5-->默认优先级
 * 2.如何设置和获取当前线程的优先级：
 *      setPriority(int p):设置当前线程的优先级
 *      getPriority():获取当前线程的优先级
 *      说明：高优先级线程要抢占低优先级线程的CPU执行权。但是只是从概率上将，高优先级的线程高概率的情况下被优先执行。
 *              并不意味着只有当高优先级的线程执行完之后，低优先级的线程才执行。
 *
 *
 * @author yangyang
 * @create 2020-11-02-9:03 下午
 */
class HelloThread extends Thread {

    public HelloThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
//                try {
//                    sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName() + ":" + i + "优先级：" + Thread.currentThread().getPriority());
            }
//            if(i % 20 == 0){
//                System.out.println("-----------");
//                this.yield();
//            }
        }
    }
}

public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread h1 = new HelloThread("Thread :1");
        //设置分线程的优先级
        h1.setPriority(Thread.MAX_PRIORITY);
        h1.start();
        //设置分线程的优先级
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
//        h1.setName("线程1");
        //给主线程命名
        Thread.currentThread().setName("主线程");
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i + "优先级：" + Thread.currentThread().getPriority());
            }
/*            if (i == 20) {
//                try {
//                    Thread.currentThread().sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                try {
                    h1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }*/
        }
//        System.out.println(h1.isAlive());
    }
}