package com.stydy.d2_util;

import java.util.SplittableRandom;

/**
    练习：完成数组工具类的设计
 */
public class ArrayUtil {
    /**
        私有构造器
     */
    private ArrayUtil(){

    }
    /**
        工具方法：静态方法
     */
    public static String toString(int[] arr){
        // 1、校验
        if (arr == null){
            return null;
        }

        // 2、拼接内容并返回
        String result = "[";
        for (int i = 0; i < arr.length; i++) {
            result += ( i == arr.length - 1 ? arr[i] : arr[i] +",");
        }
        result += "]";
        return result;
    }
}
