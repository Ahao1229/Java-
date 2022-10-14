package com.stydy.d4_static_singleinstance;

/**
    使用饿汉单例实现单例类
 */

public class Singleinstance {
    /**
        2、饿汉单例是在获取对象前，对象已经准备好了一个
        这个对象只能是一个，所以定义静态成员变量记住
     */
    public static Singleinstance instance = new Singleinstance();
    /**
            1、必须把构造器私有化
         */
    private Singleinstance(){

    }

}
