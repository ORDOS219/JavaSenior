package com.atguigu.java;

/**
 * @author yangyang
 * @create 2020-11-09-4:47 下午
 */
class StringDemo {
    public String reverse(String array, int startIndex, int endIndex) {
        char[] arr = array.toCharArray();
        for (int x = startIndex, y = endIndex; x < y; x++, y--) {
            char temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }
        return new String(arr);
    }
}

