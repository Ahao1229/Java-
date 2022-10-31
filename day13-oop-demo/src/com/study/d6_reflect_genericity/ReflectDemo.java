package com.study.d6_reflect_genericity;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class ReflectDemo {
    public static void main(String[] args) throws Exception{
        // 需求：反射实现泛型擦除后，加入其他类型的元素
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        System.out.println(list1.getClass());
        System.out.println(list2.getClass());

        System.out.println(list1.getClass() == list2.getClass()); // ArrayList.class

        System.out.println("-----------------------------");
        list2.add(23);
        list2.add(22);
        // list2.add("你好");

        Class c = list2.getClass();
        // 定位c类中的add方法
        Method add = c.getDeclaredMethod("add", Object.class);
        boolean rs = (Boolean) add.invoke(list2, "你好");
        System.out.println(rs);
        System.out.println(list2);

    }
}
