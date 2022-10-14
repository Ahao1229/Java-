package com.study.logback.d1_package;

import com.study.logback.d1_package.it.Student;


public class Test {
    public static void main(String[] args) {
        // 目标：理解一下两点
        // 1、同一个包下的类，互相可以直接访问
        System.out.println(User.onlineNumber);
        // 2、不同包下的类，必须导包才可以访问
        Student s = new Student();

        // 3、如果这个类中使用不同包下相同的类名，此时默认只能导入一个类的包，另一个类要使用全名才能访问
        Student stu = new Student();


    }
}
