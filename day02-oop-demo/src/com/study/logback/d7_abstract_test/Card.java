package com.study.logback.d7_abstract_test;

public abstract class Card {
    private String UserName;
    private double money;

    /**
     * 定义一个支付方法：表示卡片可以支付
     * 抽象方法
     */
    public abstract void pay(double SpendingMoeny);

    public Card() {
    }

    public Card(String userName, double money) {
        UserName = userName;
        this.money = money;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
