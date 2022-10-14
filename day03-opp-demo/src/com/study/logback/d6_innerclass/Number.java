package com.study.logback.d6_innerclass;

public class Number {
    public static void main(String[] args) {
        int[] arr = {2,1,3,5,4};
        int num = 0;
        int n,a;
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length -1){
                 n = arr.length - 1 - i;
                 a = arr[i];
                for (int j = 0; j < n ;j++) {
                    a *= 10;
                }
                num += a;
            }else if (i == arr.length-1){
                num += arr[i];
            }
        }
        System.out.println(num);
    }
}
