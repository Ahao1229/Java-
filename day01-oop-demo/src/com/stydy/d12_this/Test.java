package com.stydy.d12_this;

public class Test {
    public static void main(String[] args) {
        // 目标：理解this(...)的作用：本类构造器中访问本类兄弟构造器
        Student s1 = new Student("李佳浩","四方");
        System.out.println(s1.getName());
        System.out.println(s1.getSchoolName());
        /**
            不填写学校，默认对象学校是黑马
         */
        Student s2 = new Student("高航宇");
        System.out.println(s2.getName());
        System.out.println(s2.getSchoolName());
    }
}
