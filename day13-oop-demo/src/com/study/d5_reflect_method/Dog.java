package com.study.d5_reflect_method;

public class Dog {
    public String name;
    public Dog(){
    }

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run(){
        System.out.println("狗跑的贼快~~");
    }

    private void eat(){
        System.out.println("狗贼能吃肉~~");
    }

    private String eat(String name){
        System.out.println("狗吃" + name);
        return "狗吃的巨TM的开心";
    }

    public static void inAddr(){
        System.out.println("不会真有人是单身狗吧！");
    }

}


