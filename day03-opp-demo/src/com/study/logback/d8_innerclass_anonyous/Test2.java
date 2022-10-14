package com.study.logback.d8_innerclass_anonyous;


/**
 *  目标：掌握匿名内部类的使用形式（语法）
 */
public class Test2 {
    public static void main(String[] args) {
        Swimming s = new Swimming() {
            @Override
            public void swim() {
                System.out.println("学生自由泳");
            }
        };
        go(s);
        Swimming t = new Swimming() {
            @Override
            public void swim() {
                System.out.println("老师蝶泳");
            }
        };
        go(t);
    }
    /**
     *  学生 老师 运动员可以一起参加游泳比赛
     */
    public static void go(Swimming s){
        System.out.println("开始。。。");
        s.swim();
        System.out.println("结束");
    }
}

interface Swimming{
    void swim();
}


