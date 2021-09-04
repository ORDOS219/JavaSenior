package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一：缓冲流
 * 1.缓冲流
 * BufferedInputStream (read(byte[] buffer))
 * BufferedOutputStream (write(byte[] buffer,0,len) / flush()
 * BufferedReader (read(char[] cbuf) / readLine())
 * BufferedWriter (write(char[] cbuf,0,len) / flush()
 *
 * 2.作用：提供流的读取、写入的速度
 *      提高读写速度的原因：内部提供了一个缓冲区
 *
 *  3.处理流：就是套接在"已有的流"的基础上
 *
 * @author yangyang
 * @create 2021-01-17-5:05 下午
 */
public class BufferedTest {
    /*
    实现非文本文件的复制
    */
    @Test
    public void BufferedStreamTest(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File srcFile = new File("贤哥.jpg");
            File destFile = new File("贤哥3.jpg");
            //2.造流
            // 2.1 造节点流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            // 2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //3.文件具体操作
            byte[] buffer = new byte[1024];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源的关闭
            /**要求：先关闭外层的流，再关闭内层的流*/
            if(bos != null)
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(bis != null)
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            //说明：关闭外层流的同时，内层流也会自动进行关闭。关于内层流的关闭，我们可以省略。
//            fos.close();
//            fis.close();
        }
    }
    //实现文件复制的方法
    public void copyFile(String srcPath, String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            //2.造流
            // 2.1 造节点流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            // 2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //3.文件具体操作
            byte[] buffer = new byte[1024];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
//                bos.flush();//刷新缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源的关闭
            /**要求：先关闭外层的流，再关闭内层的流*/
            if(bos != null)
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(bis != null)
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            //说明：关闭外层流的同时，内层流也会自动进行关闭。关于内层流的关闭，我们可以省略。
//            fos.close();
//            fis.close();
        }
    }
    //使用缓冲流，用字节流复制视频操作
    @Test
    public void copyFileWithBuffered(){
        String srcPath = "/Users/yangyang/Desktop/01-video.mp4";
        String destPath = "/Users/yangyang/Desktop/02-video.mp4";
        long start = System.currentTimeMillis();
        copyFile(srcPath,destPath);
        long end = System.currentTimeMillis();
        System.out.println("复制需要时间为：" + (end - start));//20
    }

    /*
    使用BufferedReader和BufferedWrited实现文本文件的复制
    * */
    @Test
    public void testBufferedReaderBufferedWrited(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            //1.造文件和流（匿名的方式造）--将两步操作合并为一步
            br = new BufferedReader(new FileReader(new File("垃圾回收机制.txt")));
            bw = new BufferedWriter(new FileWriter(new File("垃圾回收机制2.txt")));

            //2.读写操作
            //方法一：
            /*char[] cbuf = new char[1024];
            int len;
            while((len = br.read(cbuf)) != -1){
                bw.write(cbuf,0,len);
            }*/
            //方法2
            String str;
            while((str = br.readLine()) != null){
                //方法一：
//                bw.write(str + "\n");//不包含换行符
                //方法二：
                bw.write(str);
                bw.newLine();//换行操作
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.关闭流资源
            if(bw != null)
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

}
