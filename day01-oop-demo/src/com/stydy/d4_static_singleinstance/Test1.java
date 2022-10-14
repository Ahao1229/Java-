package com.stydy.d4_static_singleinstance;

public class Test1 {
    public static void main(String[] args) {
        // 目标：理解饿汉单例的设计步骤
        Singleinstance s1 = Singleinstance.instance;
        Singleinstance s2 = Singleinstance.instance;
        System.out.println(s1 == s2);

    }


}
