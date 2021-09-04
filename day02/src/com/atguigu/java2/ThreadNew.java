package com.atguigu.java2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的第三种方式：实现Callable接口 --- JDK5.0新增
 * <p>
 * 如何理解实现Callable接口的方式创建多线程比实现Runnable接口创建线程的方式强大？
 * 1.call()可以有返回值
 * 2.call()可以抛出异常,被外面的操作捕获，获取异常信息
 * 3.Callable是支持泛型的
 *
 * @author yangyang
 * @create 2020-11-05-7:26 下午
 */
//①创建一个Callable接口的实现类
class NumThread implements Callable {
    int count = 0;

    //②实现接口中的call()，相当于Runnable接口中的run()，将线程需要执行的方法声明在call()中
    @Override
    public Object call() throws Exception {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                count += i;
            }
        }
        return count;
    }
}

public class ThreadNew {
    public static void main(String[] args) {
        //③创建Callable实现类的对象
        NumThread numThread = new NumThread();
        // ④将Callable实现类的对象作为参数传给FutureTask的构造器中，创建FutureTask类的对象
        FutureTask futureTask = new FutureTask(numThread);
        //⑤将FutureTask的对象传递到Thread类的构造器中，创建Thread类的对象，并start()启动线程
        new Thread(futureTask).start();
        try {
            //如果需要返回值，通过FutureTask类对象调用get()方法
            //⑥获取Callable中call()方法的返回值（如果需要返回，可选）
            Object num = futureTask.get();//get()返回值即为构造器参数Callable实现类重写的call()的返回值
            System.out.println(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
