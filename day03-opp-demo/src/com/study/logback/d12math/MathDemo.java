package com.study.logback.d12math;

public class MathDemo {
    public static void main(String[] args) {
        // 1、取绝对值：返回正数
        System.out.println(Math.abs(10));
        System.out.println(Math.abs(-10.5));

        // 2、向上去整：5
        System.out.println(Math.ceil(4.0000001)); // 5

        // 3、向下取整：4
        System.out.println(Math.floor(4.9999999)); // 4

        // 4、求指数次方
        System.out.println(Math.pow(2,3));

        // 5、四舍五入
        System.out.println(Math.round(4.49999));// 4
        System.out.println(Math.round(4.50001));// 5

        // 6、随机小数
        System.out.println(Math.random()); // 0.0 - 1.0 包前不包后

        // 拓展：3-9之间随机数
        // Math.random() * 7   0-7之间
        int data = (int)(Math.random() * 7) + 3;
        System.out.println(data);

    }
}
