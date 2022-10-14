package com.study.logback.d3_final;

public class Test2 {
    /**
     * 二、修饰静态成员变量
     */
    public static final String schoolName = "四方学院";


    /**
     * 三、修饰实例成员变量(几乎不用)  所有对象的名字都会变成一个且改不了
     */
    private final String name = "李佳浩";

    //
    public static void main(String[] args) {
        // 目标：理解final修饰变量的作用
        // 变量有几种：
        // 1、局部变量   2、成员变量（实例成员变量和静态成员变量）
        final double rate = 3.14;
        // rate = 3.19;第二次赋值报错
        buy(0.8);
        // schoolName = "清华";  报错

        Test2 t2 = new Test2();
        System.out.println(t2.name);
        // t2.name = "李艳飞"; 报错

        // 注意：final修饰引用类型的变量，其地址值不能改变，但是指向的对象的内容可以改变
        final Teacher t = new Teacher("学习，授课，吹牛逼");
        // t = "null"; 报错
        System.out.println(t.getHobby());
        t.setHobby("嘎嘎嘎");
        System.out.println(t.getHobby());


    }

    /**
     * 一、修饰局部变量
     * @param z
     */
    public static void buy(final double z){
        // z = 0.1; 第二次赋值，传过来就已经是第一次赋值了
    }
}


class Teacher{
    private String hobby;

    public Teacher(String s) {
        this.hobby = hobby;
    }


    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}