package com.atguigu.java;

import org.junit.Test;

import java.io.*;
/**
 *  一、流的分类：
 *   1.操作数据单位：字节流、字符流
 *   2.数据的流向：输入流、输出流
 *   3.流的角色：节点流、处理流
 *
 *  二、流的体系结构
 *  抽象基类         节点流（或文件流）                               缓冲流（处理流的一种）
 *  InputStream     FileInputStream   (read(byte[] buffer))        BufferedInputStream (read(byte[] buffer))
 *  OutputStream    FileOutputStream  (write(byte[] buffer,0,len)  BufferedOutputStream (write(byte[] buffer,0,len) / flush()
 *  Reader          FileReader (read(char[] cbuf))                 BufferedReader (read(char[] cbuf) / readLine())
 *  Writer          FileWriter (write(char[] cbuf,0,len)           BufferedWriter (write(char[] cbuf,0,len) / flush()
 *
 *  如果要将字符文件转换为其他的文件，但是不需要显示出来，则可以使用字节流来处理；
 *  但是字符流什么时候都不能用来处理字节流
 *
 * @author yangyang
 * @create 2021-01-14-5:28 下午
 */
public class FileReaderWriterTest {/**读操作需要一个数组来放读入的数据（或String字符串）*/
    public static void main(String[] args) {
        File file1 = new File("hello.txt");//相对于当前工程的路径
        System.out.println(file1.getAbsolutePath());

        File file2 = new File("day09/hello.txt");
        System.out.println(file2.getAbsolutePath());
    }
    /**
     * 说明点：
     * 1.read()理解：返回读入的一个字符。如果到达了文件末尾，返回-1
     * 2.异常的处理：为了保证流资源一定可以执行关闭操作，需要使用try-catch-finally处理
     * 3.读入的文件一定要存在，否则就会报FileNotFoundException
     */
    //将day09下的hello.txt文件内容读入程序中，并输出到控制台
    @Test
    public void testFileReader(){
         FileReader reader = null;
         try {
             //1.实例化File类对象，指明要操作的文件
             File file = new File("hello.txt");
             //2.提供具体的流
             reader = new FileReader(file);
             //3.数据的读入
             /**read():返回读入的一个字符。如果到达了文件末尾，返回-1*/
             /*int read = reader.read();
             while(read != -1){
                 System.out.print((char) read);
                 read = reader.read();
             }*/
             //语法上的更改，效率不变
         int read;
         while((read = reader.read()) != -1){
             System.out.print((char) read);
             }
         } catch (IOException e) {
             e.printStackTrace();
         } finally {
             //4.流的关闭
             try {
                 if(reader != null)
                    reader.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
     }

     @Test
     //对read()操作升级，使用read()的重载方法
     public void testFileReader1(){
         FileReader fr = null;
        try {
             //1.提供文件对象
             File file = new File("hello.txt");
             //2.提供fileReader对象，用于文件读入
             fr = new FileReader(file);
             char[] cbuf = new char[5];
             int len;
             /**read(char[] cbuf):返回每次读入cbuf数组中字符的个数。如果到达文件末尾，则返回-1*/
             //方式一：错误
        /* while((len = fr.read(cbuf)) != -1){
             for(int i = 0;i < cbuf.length;i++)
                 System.out.print(cbuf[i]);
         }*/
             //方式二：正确
             while((len = fr.read(cbuf)) != -1){
                 for(int i = 0;i < len; i++)
                     System.out.print(cbuf[i]);
             }
             //方式三：错误
        /*while((len = fr.read(cbuf)) != -1){
                 String str = new String(cbuf);
                 System.out.print(str);
             }*/
             //方式四：正确
             /*while((len = fr.read(cbuf)) != -1){
                 String str = new String(cbuf,0,len);
                 System.out.print(str);
             }*/
         } catch (IOException e) {
             e.printStackTrace();
         } finally {
            //4.资源的关闭
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
     }
     //从内存中写出数据到硬盘的文件中
    /**
     * 说明：
     * 1.输出操作中，对应的File可以不存在，不会报异常
     * 2.File对应的硬盘中的文件如果不存在，则在输出的过程中会自动创建此文件
     *   File对应的硬盘中的文件如果存在：
     *          1）如果流使用的构造器是 FileWriter(file)/FileWriter(file,false)：会对原有文件进行覆盖;
     *          2）如果流使用的构造器是 FileWriter(file)/FileWriter(file,true)：不会对原有文件进行覆盖，而是在原有文件的基础上进行内容的追加。
     *          */
     @Test
    public void testFileWrite(){
         FileWriter fw = null;//会对原有文件进行覆盖;
         try {
             //1.提供File类的对象，指明写出到的文件
             File file = new File("hello1.txt");

             // 2.提供FielWriter类的对象，用于数据的写出
             fw = new FileWriter(file,true);
//         FileWriter fw = new FileWriter(file,true);不会对原有文件进行覆盖，而是在原有文件的基础上进行内容的追加。

             //3.文件写出的具体操作
             fw.write("I often recall those good old days!\n");
             fw.write("You have a dream!");
         } catch (IOException e) {
             e.printStackTrace();
         } finally {
             //4.资源的关闭
             if(fw != null)
                 try {
                     fw.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
         }
     }

     //读入并写出文件（相当于对文件执行复制操作）
     @Test
    public void testFileReaderFileWriter(){
         FileReader fr = null;
         FileWriter fw = null;
         try {
             //1.提供File类的对象，指明写入和写出的文件
             File srcFile = new File("hello1.txt");
             File destFile = new File("hello2.txt");
//             File srcFile = new File("贤哥.jpg");               //不能使用字符流来处理图片等字节数据
//             File destFile = new File("贤哥1.jpg");

             // 2.提供FileReader和FielWriter类的对象，用于数据的写入和写出
             fr = new FileReader(srcFile);
             fw = new FileWriter(destFile);

             //3.读写文件的具体操作
             char[] cbuf = new char[5];
             int len;
             while((len = fr.read(cbuf)) != -1){//返回读入cbuf数组中元素的个数。如果到达文件末尾，则返回-1
                 String str = new String(cbuf,0,len);
                 fw.write(str);
             }
         } catch (IOException e) {
             e.printStackTrace();
         } finally {
             //4.流资源的关闭:以下两种方式都可以
             //方式一：
             /*try {
                 if(fr != null)
                     fr.close();
             } catch (IOException e) {//狼来了故事，此时异常已经被处理掉了
                 e.printStackTrace();
             }
             try {
                 if(fw != null)
                     fw.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }*/
             //方式二：
             try {
                 if(fr != null)
                     fr.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }finally{
                 try {
                     if(fw != null)
                         fw.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
         }
     }
}
