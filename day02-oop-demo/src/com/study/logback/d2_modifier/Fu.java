package com.study.logback.d2_modifier;

public class Fu {
    /**
     * 1、定义私有的成员
     */
    private void privateMethod(){
        System.out.println("--private--");
    }

    /**
     *  2、定义缺省的修饰的成员：只能在本类中、同包下其他类访问（包访问权限）
     */
    void method(){
        System.out.println("--缺省--");
    }
    /**
     * 3、protected修饰的方法：本类，同包的其他类，其他包的子类
     */
    protected void protectedMethod(){
        System.out.println("--protected--");
    }
    /**
     * 4、public修饰的方法：本类，同包的其他类中，其他包的子类中，其他包的无关类中。
     */
    public void publicMethod(){
        System.out.println("--public--");
    }

    public static void main(String[] args) {
        Fu f = new Fu();
        f.privateMethod();
        f.method();
        f.protectedMethod();
        f.publicMethod();
    }
}
