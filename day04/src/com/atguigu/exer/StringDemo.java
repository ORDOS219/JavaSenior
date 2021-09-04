package com.atguigu.exer;

import org.junit.Test;

/**
 * @author yangyang
 * @create 2020-11-17-8:54 下午
 */
public class StringDemo {
    /*
    获取一个字符串在另一个字符串中出现的次数。
      比如：获取“ab”在 “abkkcadkabkebfkaabkskab” 中出现的次数
     */

    public int getCount(String str1,String str2){
        int mainLen = str1.length();
        int subLen = str2.length();
        int count = 0;
        int index = 0;
        if(mainLen >= subLen){
            while((index = str1.indexOf(str2,index))!= -1){
                count++;
                index += subLen;
            }
        }
        return count;
    }

    @Test
    public void testGetCount() {
        String mainStr = "sdofnhidooniduadocuds";
        String subStr = "do";
        int count = getCount(mainStr, subStr);
        System.out.println(count);
    }
}

