package com.study.d7_reflect_framework;


import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class MybatisUtil {
    /**
     * 保存任意类型的对象
     * @param obj
     */
    public static void save(Object obj) {
        try(
                FileOutputStream os = new FileOutputStream("day13-oop-demo/src/date.txt",true);
                PrintStream ps = new PrintStream(os);
             ) {

            // 1、提取这个对象的全部成员变量：只有反射可以解决
            Class c =obj.getClass(); //(c.getSimpleName()获取当前类名  c.getName获取全限名：包名+类
            ps.println("=============="+c.getSimpleName()+"==============");
            // 2、提取全部成员变量
            Field[] fields = c.getDeclaredFields();
            // 3、获取成员变量的信息
            for (Field field : fields) {
                String name = field.getName();
                field.setAccessible(true);
                // 提取本成员变量再obj对象中的值（取值）
                String value = field.get(obj) + "";
                ps.println(name + " = " + value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
