package com.stydy.d3_code;

import java.util.ArrayList;

public class StaticDemo1 {

    public static String shcoolName;
    public static ArrayList<String> cards = new ArrayList<>();


    public static void main(String[] args) {
        // 目标：理解静态代码块
        System.out.println("-------main被触发执行了---------");
        System.out.println(shcoolName);
    }

    /**
     静态代码块，有static修饰，属于类，与类一起优先加载一次，自动触发执行
     作用：用于初始化静态资源。
     */
    static {
        System.out.println("-------静态代码块被处罚执行了---------");
        shcoolName = "四方";
        cards.add("3");
        cards.add("4");
    }
}
