package com.study.logback.d10_api_objects;

import java.util.Objects;

/**
 *  目标：掌握objects类的常用方法：equals
 */
public class Test {
    public static void main(String[] args) {
        String s1 = "istudy";
        String s2 = new String("istudy");
        String s3 = null;
        // System.out.println(s1.equals(s2)); // 留隐患，空指针异常
        System.out.println(Objects.equals(s1, s2));


        System.out.println(Objects.isNull(s3));
        System.out.println(s3 == null);
    }
}
