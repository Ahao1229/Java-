package com.study.d4_reflect_field;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

/**
 * Field的方法：给成员变量赋值和取值
 * void set(Object obj,Object value):给对象注入某个成员变量数据
 * Object get(Object obj):获取对象的成员变量的值。
 * void setAccessible(trUe);暴力反射，设置为可以直接访问私有类型的属性。
 * Class getType();获取属性的类型，返回class对象。
 * String getName();获取属性的名称。
 */
public class FieldDemo2 {
    @Test
    public void setField() throws Exception{
        // a.反射第一步，获取类对象
        Class c = Student.class;
        // b.提取某个成员变量
        Field ageF = c.getDeclaredField("age");
        ageF.setAccessible(true);   // 暴力打开权限

        // c.赋值
        Student s = new Student();
        ageF.set(s , 18);   // s.setAge(18)
        System.out.println(s);

        // d.取值
        int age = (int)ageF.get(s);
        System.out.println(age);


    }
}
