package com.stydy.d8_extends_filed_method;

public class Test {
    public static void main(String[] args) {
        // 目标：理解继承后成员的访问特点：就近原则
        Dog d =new Dog();
        d.run();
        d.lookDoor();
        d.showName();
    }
}
class Animal{
    public String name = "咪咪";
    public void run(){
        System.out.println("动物可以跑");
    }
}
class Dog extends Animal{
    public String name = "旺财";
    public void lookDoor(){
        System.out.println("狗可以看门");
    }
    public void showName(){
        String name = "局部明";
        System.out.println(name);
        System.out.println(this.name); //当前子类对象的name
        System.out.println(super.name);//当前父类对象的name
        run();
        super.run();
    }
    public void run(){
        System.out.println("狗跑的贼快");
    }
}
