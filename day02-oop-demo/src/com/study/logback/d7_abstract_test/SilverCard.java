package com.study.logback.d7_abstract_test;

public class SilverCard extends Card{
    @Override
    public void pay(double SpendingMoeny) {
        System.out.println("您当前消费为：" + SpendingMoeny);
        System.out.println(getUserName() + "先生/女士，您消费前卡片余额为：" + getMoney());
        double rs = SpendingMoeny * 0.85 ;
        System.out.println("您当前实际消费为：" + rs);
        setMoney(getMoney() - rs);
        System.out.println("您本次支付后，余额还有：" + getMoney());
    }
}
