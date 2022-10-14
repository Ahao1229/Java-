package com.study.logback.d3_polymorphic_convert;

public class Dog extends Animal {
    public String name = "狗名称";
    @Override
    public void run() {
        System.out.println("狗跑的很快");
    }

    /**
     * 独有功能
     */
    public void lookDoor(){
        System.out.println("狗在看门");
    }
}
