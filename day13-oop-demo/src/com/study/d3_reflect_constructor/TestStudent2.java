package com.study.d3_reflect_constructor;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

public class TestStudent2 {
    // 1、调用构造器得到一个类的对象返回
    @Test
    public void getDeclaredConstructor() throws Exception {
        // a. 第一步：获取类对象
        Class c = Student.class;
        // b. 定位单个构造器对象(按照参数定位无参数构造器)
        Constructor cons = c.getDeclaredConstructor();
        System.out.println(cons.getName() + "=======>" + cons.getParameterCount());

        // 如果遇到了私有的构造器，可以暴力反射
        cons.setAccessible(true);   // 权限被打开

        Student s = (Student) cons.newInstance();
        System.out.println(s);

        System.out.println("--------------");


        // c. 定位某个有参构造器
        Constructor cons1 = c.getDeclaredConstructor(String.class, int.class);
        System.out.println(cons1.getName() + "=======>" + cons1.getParameterCount());

        Student s1 = (Student) cons1.newInstance("孙悟空",1000);
        System.out.println(s1);
    }
}
