package com.study.logback.d3_final.d8_abstract_attention;

public class Test {
    public static void main(String[] args) {
        // 目标：理解抽象类的特征和注意事项。
        // 1、类有的东西，抽象类都有
        // 2、抽象类可以没有抽象方法，但是有抽象方法的必须是抽象类
        // 3、一个类继承了抽象类，必须重写完抽象类的全部抽象方法，否则这个类也必须定义成抽象类
        // Animal a = new Animal(); 报错
        // 4、抽象类不能创建对象


        /*
            final 和 abstract是什么关系？
            · 互斥关系
            · abstract定义的抽象类作为模板让子类继承，final定义的类不能被继承
            · 抽象方法定义通用功能能让子类重写，final定义的方法子类不能重写

         */





    }
}

abstract class Animal{

}
