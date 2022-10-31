package com.study.d3_reflect_constructor;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

public class TestStudent1 {
    // 1、getConstructors:
    // 获取全部的构造器：只能获取public修饰的构造器。
    // Constructor[]getConstructors()
    @Test
    public void getConstructors(){
        // a. 第一步：获取类对象
        Class c = Student.class;
        // b. 提取类中全部的构造器对象(只能拿public修饰的)
        Constructor[] constructors = c.getConstructors();
        // c. 遍历构造器
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName() + "=======>" + constructor.getParameterCount());
        }
        System.out.println("----------------------------------------");
    }

    // 2、getDeclaredConstructors():
    // 获取全部的构造器：只要你敢写，这里就能拿到，无所谓权限是否可及。
    @Test
    public void getDeclaredConstructors(){

        // a. 第一步：获取类对象
        Class c = Student.class;
        // b. 提取类中全部的构造器对象
        Constructor[] constructors = c.getDeclaredConstructors();
        // c. 遍历构造器
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName() + "=======>" + constructor.getParameterCount());
        }
        System.out.println("----------------------------------------");
    }

    // 3、getConstructor(Class...parameterTypes)
    // 获取某个构造器：只能拿public修饰的某个构造器
    @Test
    public void getConstructor() throws Exception {
        // a. 第一步：获取类对象
        Class c = Student.class;
        // b. 定位单个构造器对象(按照参数定位无参数构造器)
        Constructor cons = c.getConstructor();
        System.out.println(cons.getName() + "=======>" + cons.getParameterCount());
        System.out.println("----------------------------------------");
    }

        // 4、getDeclaredConstructor
        // 获取某个构造器：只要你敢写，这里就能拿到，无所谓权限是否可及。
        @Test
        public void getDeclaredConstructor() throws Exception {
            // a. 第一步：获取类对象
            Class c = Student.class;
            // b. 定位单个构造器对象(按照参数定位无参数构造器)
            Constructor cons = c.getDeclaredConstructor();
            System.out.println(cons.getName() + "=======>" + cons.getParameterCount());

            // c. 定位某个有参构造器
            Constructor cons1 = c.getDeclaredConstructor(String.class, int.class);
            System.out.println(cons1.getName() + "=======>" + cons1.getParameterCount());



            System.out.println("----------------------------------------");
        }

}
