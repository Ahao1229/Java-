package com.stydy.d7_extends_feature;

public class Test {
    public static void main(String[] args) {
        // 目标：理解继承的特点
        // 1、子类不能继承父类的构造器

        // 2、子类是否可以继承父类的私有成员？
        Tiger t = new Tiger();
        //t.eat(); 子类不可以继承父类私有成员，但是不能直接访问

        // 3、子类是否可以继承父类的静态成员。不算继承，算共享
        System.out.println(Tiger.location);

    }
}
class Animal{
    private void eat(){
        System.out.println("动物要吃东西");
    }

    public static String location = "长隆动物园";
}
class Tiger extends Animal{

}
