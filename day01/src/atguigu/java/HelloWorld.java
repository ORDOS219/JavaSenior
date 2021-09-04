package atguigu.java;

import java.util.Arrays;

public class HelloWorld {

    static int num = 10;
    public static void main(String[] args) {
        System.out.println();
        System.out.println("HelloWorld.main");
        System.out.println("args = " + Arrays.deepToString(args));
        System.out.println("num = " + num);
    }
}
