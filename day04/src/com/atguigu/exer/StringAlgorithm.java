package com.atguigu.exer;

import org.junit.Test;

import java.util.Arrays;
/**
 * @author yangyang
 * @create 2020-11-12-9:17 下午
 */

/**
 * 寻找两个字符串中的最大相同的子字符串
 * 前提：只有一个最大相同子字符串
 */
public class StringAlgorithm {
    public String getMaxString(String str1, String str2) {
        if (str1 != null && str2 != null) {
            String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
            String minStr = (str1.length() < str2.length()) ? str1 : str2;
            int len = minStr.length();
            for (int i = 0; i < len; i++) {
                for (int head = 0, rear = len - i; rear <= len; head++, rear++) {
                    String subStr = minStr.substring(head, rear);
                    if (maxStr.contains(subStr)) {
                        return subStr;
                    }
                }
            }
        }
        return null;
    }

    /**
     * 寻找两个字符串中的最大相同的子字符串
     * 有两个或多个相同长度的子字符串
     *
     * @param str1
     * @param str2
     * @return
     */
    public String[] getMaxSameString(String str1, String str2) {
        if (str1 != null && str2 != null) {
            StringBuilder builder = new StringBuilder();
            String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
            String minStr = (str1.length() < str2.length()) ? str1 : str2;
            int len = minStr.length();
            for (int i = 0; i < len; i++) {
                for (int head = 0, rear = len - i; rear <= len; head++, rear++) {
                    String subStr = minStr.substring(head, rear);
                    if (maxStr.contains(subStr)) {
                        builder.append(subStr + ",");
                    }
                }
//                System.out.println(builder);
//                if (builder.length() != 0) {
//                    break;
//                }
            }
            String[] split = builder.toString().replaceAll(",$", "").split("\\,");
            return split;
        }
        return null;
    }

    @Test
    public void getString() {

        String str1 = new String("abcdhello1efg");
        String str2 = new String("cvhello1a");
        StringAlgorithm s = new StringAlgorithm();
        String x = s.getMaxString(str1, str2);
        System.out.println(x);
    }

    @Test
    public void getSameSizeString() {
        String str3 = new String("abcdsfasdfsddhello1efgabcdef");
        String str4 = new String("cvhello1dasdfsdakkabcdef");
        String[] maxSameString = getMaxSameString(str3, str4);
        System.out.println(Arrays.toString(maxSameString));
    }
}