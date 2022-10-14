package com.study.logback.d1_polymorphic;

public class Dog extends Animal{
    public static String name = "子类狗";
    @Override
    public void run() {
        System.out.println("狗跑的贼溜");
    }
}
