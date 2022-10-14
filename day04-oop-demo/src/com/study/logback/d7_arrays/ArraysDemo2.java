package com.study.logback.d7_arrays;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysDemo2 {
    public static void main(String[] args) {
        // 目标：自定义数组的排序规则，Comparator比较器对象
        // 1、Arrays的sort方法对于有值特性的数组是默认升序排序
        int[] ages = {34,12,42,23};
        Arrays.sort(ages); // 升序排序
        System.out.println(Arrays.toString(ages));

        // 2、需求：降序排序(自定义比较器对象，只能支持引用类型的排序）
        Integer[] ages1 = {34,12,42,23};
        /**
         *  参数一：被排序的数组 必须是引用类型的元素
         *  参数二：匿名内部类对象，代表了一个比较器对象
         */
        Arrays.sort(ages1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 指定比较规则
//                if(o1 > o2){
//                    return 1;
//                }else if(o1 < o2){
//                    return -1;
//                }
//
//                return 0;
                // return o1 - o2; // 升序
                return -(o1 - o2);
            }
        });
        System.out.println(Arrays.toString(ages1));

        System.out.println("----------------------------");
        Student[] students = new Student[3];
        students[0] = new Student("李佳浩",20,182);
        students[1] = new Student("贾振宇",20,180);
        students[2] = new Student("渠帅达",20,176);

        // 需要自己重写排序规则
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                // 自己指定比较规则
                return (int) (o1.getHeight() - o2.getHeight());
            }
        });

        System.out.println(Arrays.toString(students));



    }
}
