package exer2;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author yangyang
 * @create 2021-01-08-3:57 下午
 */
public class FileDemo {
    @Test
    public void test1() throws IOException {
        File file = new File("/Users/yangyang/Desktop/尚硅谷/io/hello.txt");
        //创建一个与file同目录下的另一个文件文件名为haha.txt
        File destFile = new File(file.getParent(),"haha.txt");
        boolean newFile = destFile.createNewFile();
        if(newFile){
            System.out.println(destFile.getName() + " 文件创建成功！");
        }else{
            if(destFile.exists()){
                System.out.println(destFile.getName() + " 文件创建失败！文件已存在！");
            }
        }

/*        File destFile1 = new File(file.getParent(),"haha");
        boolean newFile1 = destFile1.createNewFile();
        if(newFile1){
            System.out.println(destFile1.getName() + " 文件创建成功！");
        }else{
            if(destFile.exists()){
                System.out.println(destFile1.getName() + " 文件创建失败！文件已存在！");
            }
        }*/

    }
}
