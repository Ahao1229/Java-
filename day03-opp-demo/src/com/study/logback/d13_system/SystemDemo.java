package com.study.logback.d13_system;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SystemDemo {
    public static void main(String[] args) {
        System.out.println("程序开始。。。");

        // System.exit(0);

        // 2、计算机认为时间有起源：返回1970-1-1 00:00:00 走到此刻的毫秒值
        long time = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            System.out.println("输出：" + i);
        }
//        long endTime = System.currentTimeMillis();
//        System.out.println((endTime - time) / 1000.0 + "s");

        // 3、做数组拷贝
        /**
         * Object src(参数一：被拷贝的数组),  int  srcPos（参数二：从哪个索引位置开始拷贝）,
         * Object dest(参数三：复制的目标数组), int destPos(参数四：粘贴位置),
         * int length(参数五：拷贝元素的个数)
         */
        int[] arr1 = {10,20,30,40,50,60,70};
        int[] arr2 = new int[6]; // [0,0,0,0,0,0] ==> [0,0,40,50,60,0]
        System.arraycopy(arr1, 3, arr2, 2, 3);
        System.out.println(Arrays.toString(arr2));
    }
}
