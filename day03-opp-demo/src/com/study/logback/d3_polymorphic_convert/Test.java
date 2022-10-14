package com.study.logback.d3_polymorphic_convert;

public class Test {
    public static void main(String[] args) {
        // 自动类型转换
        Animal a = new Dog();
        a.run();

        // 强制类型转换
        Animal a2 = new Tortoise();
        a2.run();
        Tortoise t = (Tortoise) a2;
        t.layEgg();

        if (a2 instanceof Tortoise){
            Tortoise tot = (Tortoise) a2;
            t.layEgg();
        }else if(a2 instanceof Dog){
            Dog d = new Dog();
            d.lookDoor();
        }
    }
}
