package com.stydy.d1_static;

public class Student {
    /**
     * 实例成员变量：无static修饰，属于对象
     */
    private String name;


    /**
     * 实例方法：属于对象的。
     */
    public void study(){
        System.out.println(name + "在好好学习天天向上");
    }


    /**
     * 静态成员方法：有Static修饰，归属于类，可以共享访问
     */
    public static int getMax(int age1 , int age2){
        return age1 > age2 ? age1 : age2;
    }

    public static void main(String[] args) {
        // 1、类名，静态成员方法
        System.out.println(Student.getMax(10,3));
        // 注意，同一个类中，访问静态方法，类名可以省略不写。
        System.out.println(getMax(10,32));

        // 2、对象.实例方法
        Student s = new Student();
        s.name = "李佳浩";
        s.study();

        // 3、对象.静态方法（语法可行，但不推荐）
        System.out.println(s.getMax(13,15));
    }
}
