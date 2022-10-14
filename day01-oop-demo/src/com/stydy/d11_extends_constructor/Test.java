package com.stydy.d11_extends_constructor;

public class Test {
    public static void main(String[] args) {
        // 目标：学习子类构造器如何去访问父类有参数构造器
        Teacher t =new Teacher("地雷",18);
        System.out.println(t.getNama());
        System.out.println(t.getAge());
    }
}
