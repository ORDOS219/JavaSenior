package atguigu.java;
/**
 * 创建线程的方式二：
 * 1.创建一个实现Runnable接口的实现类
 * 2.实现类去实现Runnable类中的抽象方法run()
 * 3.创建实现类的对象
 * 4.将实现类的实例作为参数传递给Thread类的实例
 *
 * 两种创建线程的方式对比：
 * 开发当中，优先选择实现Runnable接口的方式
 * 原因 :1.实现接口的方式没有类的单继承性的局限性
 *      2.实现的方式更适合来处理多个线程有共享数据的情况
 *
 * 联系 :
 *  相同点：class Thread implements Runnable{}
 *  两种创建线程的方法都需要重写Runnable类中的run()方法，将线程要执行的逻辑声明在run()方法中。
 *         (Thread类中也实现了Runnable类中的run()方法)
 *
 * @author yangyang
 * @create 2020-11-03-9:54 上午
 */

class mThread implements Runnable{
    @Override
    public void run() {
        for(int i = 0;i < 100; i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
    mThread mt = new mThread();
    Thread t1 = new Thread(mt);//Thread(Runnable target)
        t1.setName("线程1：");
        t1.start();
    Thread t2 = new Thread(mt);
        t2.setName("线程2：");
        t2.start();

    }
}
