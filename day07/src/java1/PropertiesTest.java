package java1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author yangyang
 * @create 2020-12-17-6:29 下午
 */
public class PropertiesTest {

    //properties：常用来处理配置文件。key和value都是String类型
    public static void main(String[] args) throws Exception {
        FileInputStream file = null;
        try {
            Properties pros = new Properties();
            file = new FileInputStream("jdbc.properties");
            pros.load(file);//加载对应的流文件

            String name = pros.getProperty("name");
            String password = pros.getProperty("password");
            System.out.println("name=" + name + " password=" + password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(file != null){
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
