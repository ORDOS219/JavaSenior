package com.atguigu.exer;

/**
 * @author yangyang
 * @create 2020-11-05-9:20 上午
 */

class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }
    //存钱
    public synchronized void deposit(int money){
        if(money > 0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance += money;
            System.out.println(Thread.currentThread().getName() + ":存钱成功，余额为：" + balance);
        }
    }
}

class Customer extends Thread {
    private Account acct;

    public Customer(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        for(int i = 0; i < 3;i++){
            acct.deposit(1000);
        }
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account acct = new Account(0);
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);
        c1.setName("客户一");
        c2.setName("客户二");
        c1.start();
        c2.start();
    }
}
