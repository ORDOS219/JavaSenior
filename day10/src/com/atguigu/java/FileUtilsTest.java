package com.atguigu.java;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author yangyang
 * @create 2021-03-10-11:50 上午
 */
public class FileUtilsTest {
    public static void main(String[] args) {
        File srcFile1 = new File("day10/爱情与友情.jpg");//main()方法的相对路径是当前工程
        File srcFile2 = new File("day10/爱情与友情3.jpg");
        try {
            FileUtils.copyFile(srcFile1,srcFile2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
