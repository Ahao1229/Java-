package com.study.logback.d8_lambda;

public class LambdaDemo1 {
    public void main(String[] args) {
        // 目标：学会使用Lambda的标准格式建华匿名内部类的代码形式
        Animal a = new Animal(){

            @Override
            public void run() {
                System.out.println("乌龟跑的很慢~~~~~");
            }
        };
        a.run();

    }
    abstract class Animal{
        public abstract void run();
    }
}
