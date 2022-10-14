package com.study.logback.d2_polymorphic_advantage;

public class Tortoise extends Animal{
    public String name = "乌龟名称";

    @Override
    public void run() {
        System.out.println("乌龟跑的很慢");
    }
}
