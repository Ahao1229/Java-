package com.study.d7_reflect_framework;

/**
 *  目标：提供一个通用框架，支持保存所有对象的具体信息。
 */
public class ReflectDemo {
    public static void main(String[] args) throws Exception {
        Student s = new Student();
        s.setName("贾四");
        s.setClassName("学习1班");
        s.setAge(20);
        s.setHobby("美女，美女和美女");
        s.setSex('男');
        MybatisUtil.save(s);

        Teacher t = new Teacher();
        t.setName("美女老师");
        t.setSex('女');
        t.setSalary(100000000.0);
        MybatisUtil.save(t);


    }
}
