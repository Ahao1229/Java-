package com.study.logback.d1_polymorphic;

public class Tortoise extends Animal{
    public static String name = "子类乌龟";
    @Override
    public void run() {
        System.out.println("乌龟跑的贼慢");
    }
}
