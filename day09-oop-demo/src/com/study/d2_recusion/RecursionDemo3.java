package com.study.d2_recusion;

/**
 * 猴子吃桃，一天一半多一个，第10天剩一个
 */
public class RecursionDemo3 {
    public static void main(String[] args) {

        System.out.println(f1(1));

        System.out.println(f(10));
    }

    /**
     * 方法一：
     */
    public static int f(int x){
        if(x == 1){
            return 1;
        }else {
            return (f(x-1)+1)*2;
        }
    }
    /**
     * 方法二：
     */
    public static int f1(int x){
        if (x == 10){
            return 1;
        }else {
            return 2 * f1(x + 1) + 2;
        }
    }

}
