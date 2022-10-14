package com.study.logback.d3_polymorphic_convert;

public class Tortoise extends Animal {
    public String name = "乌龟名称";

    @Override
    public void run() {
        System.out.println("乌龟跑的很慢");
    }
    /**
     * 独有功能
     */
    public void layEgg(){
        System.out.println("乌龟在下蛋");
    }
}
