package com.study.logback.d8_lambda;

public class LambdaDemo2 {
    public static void main(String[] args) {
        // 目标：学会使用Lambda的标准格式建华匿名内部类的代码形式
        // Lambda只能简化接口中只有一个抽象方法的匿名内部类形式

    go(() -> {
        System.out.println("老师有用贼溜~~~~~");
    });
    }
    public static void go(Swimming s){
        System.out.println("开始。。。");
        s.swim();
        System.out.println("结束。。。");
    }

}

@FunctionalInterface // 一旦加上这个注解必须是函数式接口，里面只能有一个抽象方法
interface Swimming{
    void swim();
}