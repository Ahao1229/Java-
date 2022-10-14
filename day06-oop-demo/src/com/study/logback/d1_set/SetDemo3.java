package com.study.logback.d1_set;

import java.util.HashSet;
import java.util.Set;

/**
 *  目标：让Set集合吧重复内容去掉
 */
public class SetDemo3 {
    public static void main(String[] args) {
        // Set集合去除重复原因：先判断哈希表，在判断equals
        Set<Student> sets = new HashSet<>();
        Student s1 = new Student("芜湖",20,'男');
        Student s2 = new Student("芜湖",20,'男');
        Student s3 = new Student("起飞",21,'男');

        sets.add(s1);
        sets.add(s2);
        sets.add(s3);

        System.out.println(sets);

    }
}
