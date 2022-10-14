package com.study.logback.d2_modifier.itcast;

import com.study.logback.d2_modifier.Fu;

public class Zi extends Fu {
    public static void main(String[] args) {
        Zi z = new Zi();
        z.protectedMethod();
        z.publicMethod();
        Fu f = new Fu();
        f.publicMethod();
        /*
            在子类中需要创建子类对象访问父类的方法，所有下面的都报错
            f.privateMethod();
            f.method();
            f.protectedMethod();
        */
        }
}



