package com.atguigu.java;

/**
 * @author yangyang
 * @create 2020-12-09-7:36 下午
 */
public class MyDate implements Comparable{

    private int year;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof MyDate){
            MyDate date = (MyDate)o;

        int minusYear = this.getYear() - date.getYear();
        if (minusYear != 0) {
            return minusYear;
        }
        //能到这一步说明"年"相等
        int minusMonth = this.getMonth() - date.getMonth();
        if (minusMonth != 0) {
            return minusMonth;
        }

        return this.getDay() - date.getDay();
    }else{
            throw new RuntimeException("传入比较类型错误");
        }
    }
}
