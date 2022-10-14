package com.study.logback.d7_abstract_test;

public class GoldCard extends Card{

    @Override
    public void pay(double SpendingMoney) {
        System.out.println("您当前消费为：" + SpendingMoney);
        System.out.println("您卡片支付前余额为：" + getMoney());
        // 优惠计算
        double rs = SpendingMoney * 0.8;
        System.out.println(getUserName() + "先生/女士，您实际支付为：" + rs);
        // 更新账户余额
        setMoney(getMoney() - rs);
        System.out.println("您本次支付后，余额还有：" + getMoney());
    }
}
