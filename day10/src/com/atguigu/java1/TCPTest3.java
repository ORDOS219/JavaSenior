package com.atguigu.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例题3：从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端；并关闭相应的连接。
 *
 * @author yangyang
 * @create 2021-03-11-5:15 下午
 */
public class TCPTest3 {
    /*
       这里涉及到的异常，应该使用try-catch-finally处理
    */
    @Test
    public void client() throws IOException {
        //1.
        InetAddress inet = InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(inet, 9090);
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

        //传输完成后关闭数据的输出，因为read()是阻塞式操作
        socket.shutdownOutput();

        //5.接收来自于服务器端的数据，并显示到控制台上
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] bufferr = new byte[20];
        int lenn;
        while ((lenn = is.read(bufferr)) != -1) {
            baos.write(buffer, 0, lenn);
        }
        System.out.println(baos.toString());
        //6.
        baos.close();
        fis.close();
        os.close();
        socket.close();
    }

    /*
        这里涉及到的异常，应该使用try-catch-finally处理
    */
    @Test
    public void server() throws IOException, InterruptedException {
        //1.
        ServerSocket ss = new ServerSocket(9090);
        //2.
        Socket socket = ss.accept();
        //3.
        InputStream is = socket.getInputStream();
        //4.
        FileOutputStream fos = new FileOutputStream(new File("beauty2.jpg"));
        //5.
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }
        //6.
        System.out.println("图片已经收到！");

        OutputStream os = socket.getOutputStream();
        os.write("你好，我已经收到信息！".getBytes());
        //7.
        os.close();
        fos.close();
        is.close();
        socket.close();
        ss.close();
    }
}