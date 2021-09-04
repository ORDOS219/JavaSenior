package com.atguigu.java;

/**
 * @author yangyang
 * @create 2020-11-21-8:38 下午
 */
public class Goods implements Comparable {
    private String name;
    private double price;

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    /*
     * 实现价格的升序比较
     * */
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods goods = (Goods) o;
            //方式一：
            if (this.price > goods.price) {
                return 1;
            } else if (this.price < goods.price) {
                return -1;
            } else {
                return this.name.compareTo(goods.name);
//                return -this.name.compareTo(goods.name);//从大到小排
            }
//            //方式二：
//            return Double.compare(this.price,goods.price);
        }
        throw new RuntimeException("传入类型不一致！");
    }
}
