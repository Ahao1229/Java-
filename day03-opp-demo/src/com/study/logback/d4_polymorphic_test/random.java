package com.study.logback.d4_polymorphic_test;

import java.util.Random;

public class random {
    public static void main(String[] args) {
        int[] arr = new int[6];
        Random r = new Random();
        int sum = 0;
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100);
            sum += arr[i];
            System.out.print(i == arr.length - 1 ? arr[i] : arr[i] + ",");
        }
        System.out.println("]");
        System.out.println("随机数和为：" + sum);
    }
}
