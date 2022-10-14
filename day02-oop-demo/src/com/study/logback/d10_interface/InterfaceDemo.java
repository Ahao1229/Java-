package com.study.logback.d10_interface;

/**
 *  声明了一个接口：体现了一种规范，规范一定是公开的。都需要声明为public。
 */
public interface InterfaceDemo {
    // 目标：接口中成分特点：JDK8之前接口中只能有抽象方法和常量
    // 1、常量
    String SCHOOL_NAME = "四方";
    //public static final String SCHOOL_NAME = "四方";
    // 2、抽象方法
    // 由于接口体现规范思想，规范默认公开的，所以代码层面，public abstract 可以省略不写

    void run();
    // public abstract void run();
    void eat();
    // public abstract void eat();
}
