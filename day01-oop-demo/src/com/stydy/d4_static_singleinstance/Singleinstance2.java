package com.stydy.d4_static_singleinstance;
/*
    懒汉单例
 */
public class Singleinstance2 {
    /**
        2、定义一个静态的成员变量负责存储一个对象。
            只加载一次，只有一份
     */
    private static Singleinstance2 instance;
    /**
        3、提供一个方法，对外返回单例对象
     */
    public static Singleinstance2 getInstance(){
        if(instance == null){
            // 第一次来拿对象，此时需要创建对象
            instance = new Singleinstance2();
        }
        return instance;
    }
    /**
        1、私有化构造器
     */
    private Singleinstance2(){

    }
}
