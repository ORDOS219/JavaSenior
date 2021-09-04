package com.atguigu.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile的使用：
 * 1.RandomAccessFile直接继承于java.lang.Object类，实现DataInput和DataOutput接口
 * 2.RandomAccessFile既可以作为一个输入流，又可以作为一个输出流
 *
 * 3.如果RandomAccessFile作为输出流时，写出到的文件如果不存在，则在执行过程中自动创建。
 * 如果写出到的文件存在，则会对原有文件内容进行覆盖。（默认情况下，从头覆盖）
 *
 * 4. 可以通过相关的操作，实现RandomAccessFile“插入”数据的效果
 *
 * @author yangyang
 * @create 2021-03-09-3:15 下午
 */
public class RandomAccessFileTest {
    @Test
    public void test1() {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("爱情与友情.jpg"), "r");
            raf2 = new RandomAccessFile(new File("爱情与友情4.jpg"), "rw");

            byte[] buffer = new byte[5];
            int len;
            while ((len = raf1.read(buffer)) != -1) {
                raf2.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf2 != null) {
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(new File("hello.txt"), "rw");
            raf.seek(3);//将指针调到3的位置，默认不加的时候是0
            raf.write("xyz".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void test3() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt","rw");
        raf1.seek(3);//将指针调到角标为3的位置
        //保存指针3后面的所有数据到StringBuilder中
        StringBuilder sb = new StringBuilder((int) new File("hello.txt").length());
        byte[] buffer = new byte[20];
        int len;
        while((len = raf1.read(buffer)) != -1){
            sb.append(new String(buffer,0,len));
        }
        //调回指针，写入“xyz”
        raf1.seek(3);
        raf1.write("xyz".getBytes());
        //将StringBuilder中的数据写入到文件中
        raf1.write(sb.toString().getBytes());
        raf1.close();
        //思考：将StringBuilder替换为ByteArrayOutputStream
    }
}
