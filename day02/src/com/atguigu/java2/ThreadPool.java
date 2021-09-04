package com.atguigu.java2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用线程池的方式创建线程
 *
 * @author yangyang
 * @create 2020-11-06-9:31 上午
 */
class NumberThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

class NumberThread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

public class ThreadPool {
    public static void main(String[] args) {
        //①提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        //如果需要可以做一些设置 需要通过接口的实现类才能设置
//        ThreadPoolExecutor service1 = (ThreadPoolExecutor)service;
//        service1.setCorePoolSize(15);
//        service1.setKeepAliveTime();

        //②执行指定的线程操作，需提供实现接口实现类的对象(Runnable接口 或 Callable接口)
        service.execute(new NumberThread());//适用于Runnable
        service.execute(new NumberThread1());//适用于Runnable
//        service.submit(new NumberThread());//适用于Callable
        //③关闭连接池
        service.shutdown();//关闭线程池
    }
}
