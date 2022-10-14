package com.study.logback.d4_polymorphic_test;

/**
 *  目标：USB设备模拟
 *  1、定义USB接口，接入拔出
 *  2、定义2个USB的实现类，鼠标，键盘
 *  3、创建一个电脑对象，穿件USB设备对象，安装启动
 */
public class Test {
    public static void main(String[] args) {
        // a、创建电脑对象
        Computer c = new Computer("MacBook Pro");
        c.start();

        // b、创建鼠标对象，键盘对象
        USB k = new KeyBoard("Varmilo");
        c.installUSB(k);
        System.out.println("-------------------------");
        USB m = new Mouse("Logitech");
        c.installUSB(m);

    }
}
