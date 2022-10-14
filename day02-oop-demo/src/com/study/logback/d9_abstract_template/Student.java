package com.study.logback.d9_abstract_template;

import java.util.Random;

public abstract class Student {
    /**
     * 正式：声明模板方法
     * 用final修饰方法，避免方法被子类重写,更安全、专业、更优雅
     */
    public final void write(){
        System.out.println("\t\t\t我的区长父亲");
        System.out.println("我的爸爸是区长！");
        // 正文部分（每个类都要写的，每个子类写的情况不一样）
        // 因此，模板方法吧正文部分定义成抽象方法，交给具体的子类来完成

        System.out.println(writeMain());

        System.out.println("后来啊，我才知道，我的爸爸不仅是我自己的爸爸，更是全区人民的爸爸");
    }
    public abstract String writeMain();
}

