package com.study.logback.d2_polymorphic_advantage;

public class Test {
    public static void main(String[] args) {
        Animal d = new Dog();
        Animal t = new Tortoise();

        go(d);
        System.out.println("-----------------");
        go(t);

        // d.lookDoor(); // 多态下不能访问子类独有功能
    }

    /**
     *  要求：所有动物都可以进来毕设
     */
    public static void go(Animal a){
        System.out.println("开始...");
        a.run();
        System.out.println("结束...");
    }

}
