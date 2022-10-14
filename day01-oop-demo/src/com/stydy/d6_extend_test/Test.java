package com.stydy.d6_extend_test;

public class Test {
    public static void main(String[] args) {
        // 目标：理解继承的设计思想
        Student s =new Student();
        s.setName("李佳浩");
        s.setAge(20);
        s.setClassName("方2105Z-1");
        System.out.println(s.getName()+"\t\t"+s.getAge()+"\t\t"+s.getClassName());
        s.writeInfo();
        s.queryCourse();
        Teacher t = new Teacher();
        t.setName("李老师");
        t.setAge(25);
        t.setDepartmentName("计算机系");
        System.out.println(t.getName()+"\t\t"+t.getAge()+"\t\t"+t.getDepartmentName());
        t.release();
        t.queryCourse();
    }
}
