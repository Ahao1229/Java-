package com.study.logback.d9_api_object;

/**
 * 目标： 掌握object类中toString方法的使用
 */
public class Test1 {
    public static void main(String[] args) {
        Student s = new Student("周雄",'男',19);
        System.out.println(s.toString());
        System.out.println(s);
    }
}
