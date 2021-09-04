package com.atguigu.java;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 测试 FileInputStream 和 FileOutStream 的使用
 *
 * 结论：
 *  1. 对于文本文件(.txt,.java,.c,.cpp)，使用字符流处理
 *  2. 对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt,...)，使用字节流处理
 *
 * @author yangyang
 * @create 2021-01-16-6:07 下午
 */
public class FileInputOutputStreamTest {
    @Test
    public void FileInputStream() throws IOException {
        File file = new File("hello.txt");
        FileInputStream fis = new FileInputStream(file);
        byte[] cbuf = new byte[5];
        int len;
        while((len = fis.read(cbuf)) != -1){
            String str = new String(cbuf,0,len);
            System.out.print(str);
        }
    }

    //实现对图片的复制操作
    @Test
    public void testFileInputOutputStream() throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File("贤哥.jpg");
            File destFile = new File("贤哥2.jpg");
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            byte[] cbuf = new byte[5];
            int len;
            while((len = fis.read(cbuf)) != -1){
                fos.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(fos != null)
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    //指定路径下文件的复制
    public void copyFile(String srcPath, String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            byte[] cbuf = new byte[1024];
            int len;
            while((len = fis.read(cbuf)) != -1){
                fos.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(fos != null)
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
    //不适用缓冲流，用字节流复制视频操作
    @Test
    public void copyTest(){
        String srcPath = "/Users/yangyang/Desktop/01-video.mp4";
        String destPath = "/Users/yangyang/Desktop/03-video.mp4";
        long start = System.currentTimeMillis();
        copyFile(srcPath,destPath);
        long end = System.currentTimeMillis();
        System.out.println("复制文件所花费的时间为：" + (end - start));//67
    }
}