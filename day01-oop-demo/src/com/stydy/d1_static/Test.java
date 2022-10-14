package com.stydy.d1_static;

public class Test {
    /**
     * 静态成员
     */
    public static int onlineNumber = 10;
    public static void test2(){
        System.out.println("===test2===");
    }

    /**
     * 实例成员
     */
    private String name;
    public void run(){
        System.out.println(name + "跑的快");
    }

    // 3、静态方法中不可以出现this关键字
    public static void test3(){
       //System.out.println(this);
       // this代表当前对象，我们不一定用对象调用静态方法，所以不可以出现this
    }

    // 2、实例方法可以访问静态成员，也可以访问实例成员
    public void go(){
        System.out.println(Test.onlineNumber);
        System.out.println(onlineNumber);
        test2();
        System.out.println(name);
        // 实例方法是属于对象的，调用实例方法需要对象，所以在实例方法里调用实例成员name时不需要单独调用对象
        System.out.println(this);
        run();
    }


    // 1、静态方法只能访问静态成员，不能直接访问实例成员
    public static void test(){
        System.out.println(Test.onlineNumber);
        System.out.println(onlineNumber);
        test2();
        Test t = new Test();
        t.run();
    }


    public static void main(String[] args) {
        // 目标：理解static 访问相关语法：面试笔试题，或者以后理解程序，很重要的知识（拓展）

    }
}
