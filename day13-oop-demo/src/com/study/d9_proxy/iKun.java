package com.study.d9_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class iKun {
    /**
     *  设计一个方法，返回一个明星对象的代理对象
     */
    public static Ctrl getProxy(Kun kun){
        // 为蔡徐坤这个对象，生成一个代理对象iKun
        /**
         *  public static Object newProxyInstance(ClassLoader loader,
         *                                           Class<?>[] interfaces, 对象实现的接口列表
         *                                           InvocationHandler h)
         */
        return (Ctrl) Proxy.newProxyInstance(kun.getClass().getClassLoader(),
                kun.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("别黑我家哥哥，小心我家哥哥下蛋不给你吃~~~");
                        // 真正的鲲鲲去唱歌跳舞。。。
                        // method 正在调用的方法对象         args 代表这个方法的参数
                        Object rs = method.invoke(kun, args);
                        System.out.println("小黑子，漏出鸡脚了吧~~~~~~~");
                        System.out.println();
                        return rs;
                    }
                });
    }
}
