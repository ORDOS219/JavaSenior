package com.atguigu.java;

/**
 * 使用enum关键字来定义枚举类
 * 说明：定义的枚举类默认继承于java.lang.Enum类
 *
 *
 *
 * @author yangyang
 * @create 2020-11-23-10:58 上午
 */
interface info {
    public abstract void show();
}

public class SeasonTest1 {
    public static void main(String[] args) {

        Season1 autumn = Season1.AUTUMN;
        System.out.println(autumn.toString());
        System.out.println("**************");

        //values()测试：
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + ": ");
            values[i].show();
        }
        System.out.println();

        //valueOf(String objName):返回枚举类中与objName同名的enum对象
        Season1 summer = Season1.valueOf("SUMMER");
        System.out.println(summer);

    }
}

enum Season1 implements info {
    SPRING("春天", "春风得意") {
        @Override
        public void show() {
            System.out.println("春天在哪里");
        }
    },
    SUMMER("夏天", "烈日炎炎") {
        @Override
        public void show() {
            System.out.println("宁静的夏天");
        }
    },
    AUTUMN("秋天", "秋高气爽") {
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天", "寒风刺骨") {
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };

    private final String SeasonName;
    private final String SeasonDesc;

    private Season1(String seasonName, String seasonDesc) {
        this.SeasonName = seasonName;
        this.SeasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return SeasonName;
    }

    public String getSeasonDesc() {
        return SeasonDesc;
    }

/*    @Override
    public String toString() {
        return "Season1{" +
                "SeasonName='" + SeasonName + '\'' +
                ", SeasonDesc='" + SeasonDesc + '\'' +
                '}';
    }*/
}