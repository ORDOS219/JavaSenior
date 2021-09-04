package com.atguigu.exer;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author yangyang
 * @create 2021-01-18-12:55 下午
 */
public class PicTest {
    //图片的加密
    @Test
    public void test1(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(new File("贤哥.jpg"));
            fos = new FileOutputStream(new File("贤哥secret.jpg"));

            byte[] cbuf = new byte[10];
            int len;
            while((len = fis.read(cbuf)) != -1){
                //对字节数组进行修改达到加密的目的
                    //不能用增强for循环，数组中的内容没有被修改
                /*for(byte b : cbuf){
                    b = (byte) (b ^ 5);
                }*/
                for(int i = 0;i < len;i++){
                    cbuf[i] = (byte) (cbuf[i] ^ 5);//做异或操作^进行加密
                }
                fos.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null)
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    @Test
    public void test2(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("贤哥secret.jpg");
            fos = new FileOutputStream("贤哥resecret.jpg");
            byte[] cbuf = new byte[10];
            int len;
            while((len = fis.read(cbuf)) != -1){
                for(int i = 0;i < len; i++){
                    cbuf[i] = (byte) (cbuf[i] ^ 5);//m^n^n：相当于m没有^n，两次异或(^)相当于没有异或(^)
                }
                fos.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null)
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
