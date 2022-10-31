package com.study.d5_reflect_method;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class MethodDemo1 {
    /**
     *  1、获得类中的所有成员方法对象
     */
    @Test
    public void getDeclaredMethods(){
        // a.获取类对象
        Class c = Dog.class;
        // b.提取全部方法，包括私有
        Method[] methods = c.getDeclaredMethods();
        // c.遍历全部方法
        for (Method method : methods) {
            System.out.println(method.getName() + " 返回值类型：" + method.getReturnType() +
            " 参数名称：" + method.getParameterCount());
        }
    }

    /**
     *  2、获取某个方法对象
     */
    @Test
    public void getDeclaredMethod() throws Exception{
        // a.获取类对象
        Class c = Dog.class;
        // b.提取单个方法对象
        Method m = c.getDeclaredMethod("eat");
        Method m2 = c.getDeclaredMethod("eat", String.class);

        // 暴力打开权限
        m.setAccessible(true);
        m2.setAccessible(true);

        // c.触发方法的执行
        Dog d = new Dog();
        // 注意没有结果返回回来的话，返回null
        Object result = m.invoke(d);
        System.out.println(result);

        Object result2 = m2.invoke(d,"肉");
        System.out.println(result2);
    }

}
