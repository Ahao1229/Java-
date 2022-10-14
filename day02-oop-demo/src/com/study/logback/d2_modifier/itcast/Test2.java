package com.study.logback.d2_modifier.itcast;

import com.study.logback.d2_modifier.Fu;

public class Test2 {
    public static void main(String[] args) {
        Fu f = new Fu();
//        f.privateMethod();       私有的，报错
//        f.method();               只能在同包下，报错
//        f.protectedMethod();      不同包的子类下，报错
        f.publicMethod();
    }
}
