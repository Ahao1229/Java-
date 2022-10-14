package com.study.logback.d8_innerclass_anonyous;

public class Test {
    public static void main(String[] args) {
        // 匿名内部类编译后也会产生单独的class文件

        Animal a = new Animal() {
            @Override
            public void run() {
                System.out.println("老虎跑的快");
            }
        };
        a.run();
        People p = new People(){
            @Override
            public void go() {
                super.go();
                System.out.println("人可以跑很快");
            }
        };
        p.go();
    }
}

//class Tiger extends Animal{
//
//    @Override
//    public void run() {
//        System.out.println("老虎跑的很快");
//    }
//}

abstract class Animal{
    public abstract void run();
}
class People{
    public void go(){

    }
}
