package com.stydy.d1_static;

public class User {
    /**
     * 在线人数
     * 注意：static修饰的成员变量，静态成员变量，只在内存中有一份可以被共享
     */
    public  static int onlineNumber = 161;
    /**
     * 实例成员变量，无static修饰，属于每个对象的，必须使用对象名
     */
    private String name;
    private int age;

    public static void main(String[] args) {
        User u2 = new User();
        u2.name = "张三";
        u2.age = 26 ;
        System.out.println(u2.name);
        System.out.println(u2.age);
        u2.onlineNumber++;

        System.out.println(u2.onlineNumber);
        System.out.println(User.onlineNumber);// 推荐方式
        // 注意：同一个类中静态成员变量的访问可以忽略类名
        System.out.println(onlineNumber);
    }

}
