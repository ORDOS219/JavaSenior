package com.atguigu.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程：
 * 例题2：客户端发送文件给服务端，服务端将文件保存在本地。
 *
 * @author yangyang
 * @create 2021-03-11-4:23 下午
 */
public class TCPTest2 {
    /*
        这里涉及到的异常，应该使用try-catch-finally处理
     */
    @Test
    public void client() throws IOException {
        //1.
        InetAddress inet = InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(inet, 8800);
        //2.
        OutputStream os = socket.getOutputStream();
        //3.
        FileInputStream fis = new FileInputStream(new File("beauty.jpg"));
        //4.
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1) {//read到buffer中，返回长度不等于-1
            os.write(buffer, 0, len);
        }
        //5.
        fis.close();
        os.close();
        socket.close();
    }
    /*
        这里涉及到的异常，应该使用try-catch-finally处理
    */
    @Test
    public void server() throws IOException {
        //1.
        ServerSocket ss = new ServerSocket(8800);
        //2.
        Socket socket = ss.accept();
        //3.
        InputStream is = socket.getInputStream();
        //4.
        FileOutputStream fos = new FileOutputStream(new File("beauty1.jpg"));
        //5.
        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }
        //6.
        fos.close();
        is.close();
        socket.close();
        ss.close();
    }
}