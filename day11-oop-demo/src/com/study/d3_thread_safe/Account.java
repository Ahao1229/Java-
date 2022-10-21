package com.study.d3_thread_safe;

public class Account {
    private String cardID;
    private double money;

    public Account() {
    }

    public Account(String cardID, double money) {
        this.cardID = cardID;
        this.money = money;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    /**
     * 小明小红取钱
     */
    public void drawMoney(Double money) {
        // 1、先看是谁来取钱
        String name= Thread.currentThread().getName();
        // 2、判断账户是否够钱
        if (this.money >= money){
            // 2、取钱
            System.out.println(name + "取钱成功，取出：" + money);
            // 3、更新余额
            this.money -= money;
            System.out.println(name + "取钱后。剩余：" + this.money);
        }else {
            // 4、余额不足
            System.out.println(name + "来取钱，余额不足!");
        }




    }
}
