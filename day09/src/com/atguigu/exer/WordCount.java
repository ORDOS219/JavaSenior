package com.atguigu.exer;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 获取文本中字符出现的次数，并写入到文档中
 *
 * 思路：
 * 1.遍历文本的每一个字符
 * 2.将字符出现的次数存在map中
 * Map<Character,Integer> map = new HasMap<Chatacter,Integer>;
 * map.put('a',18);
 * map.put('你'，2);
 * 3.将map中的数据写入到文件中
 * @author yangyang
 * @create 2021-01-20-1:37 下午
 */
public class WordCount {
    //获取文本中字符出现的次数，并写入到文档中
    @Test
    public void wordCount(){
        FileReader fr = null;
        BufferedWriter bw = null;
        try {
            //将文本中的字符以及其出现次数通过map<Character,Integer> 中的key-value存储
            Map<Character,Integer> map = new HashMap<Character,Integer>();
            fr = new FileReader("dbcp.txt");
            int len = 0;
            while((len = fr.read()) != -1){//没有到文件末端时
                char c = (char)len;//将字符由int型还原为char型
                if(map.get(c) == null){//如果在map中没有存该字符
                    map.put(c,1);//存入map中，个数为1
                }else{
                    map.put(c,map.get(c) + 1);//存在则个数为value+1
                }
            }
            bw = new BufferedWriter(new FileWriter(new File("CountResult.txt")));
            Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();//遍历map需要通过set实现，map中的数据为无序的
            for(Map.Entry<Character,Integer> entry : entrySet){
                switch(entry.getKey()){
                    case ' ':
                        bw.write("空格=" + entry.getValue());
                        break;
                    case '\t':
                        bw.write("tab键=" + entry.getValue());
                        break;
                    case '\r':
                        bw.write("回车=" + entry.getValue());
                        break;
                    case '\n':
                        bw.write("换行=" + entry.getValue());
                        break;
                    default:
                        bw.write(entry.getKey() + "=" + entry.getValue());
                        break;
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bw != null)
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(fr != null)
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

}