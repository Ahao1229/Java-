package com.study.logback.d7_abstract_test;

public class Test {
    public static void main(String[] args) {
        // 目标：学习抽象类的基本使用，做父类被继承，重写抽象方法
        System.out.println("您当前是金卡用户：");
        GoldCard c = new GoldCard();
        c.setMoney(10000);
        c.setUserName("地雷");
        c.pay(300);
        System.out.println("------------------------------");
        System.out.println("您当前是银卡用户：");
        SilverCard s = new SilverCard();
        s.setMoney(5000);
        s.setUserName("高航宇");
        s.pay(300);

    }
}