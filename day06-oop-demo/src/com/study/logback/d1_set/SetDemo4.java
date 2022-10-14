package com.study.logback.d1_set;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetDemo4 {
    public static void main(String[] args) {
        // 看看Set系列集合的特点： HashSet LinkedSet TreeSet

        // 无序，不重复，无索引

//        Set<String> sets = new TreeSet<>();  排序，不重复，无索引
        Set<String> sets = new LinkedHashSet<>(); //有序 不重复 无索引
        sets.add("MySQL");
        sets.add("MySQL");
        sets.add("Java");
        sets.add("Java");
        sets.add("HTML");
        sets.add("HTML");
        sets.add("SpringBoot");
        sets.add("SpringBoot");
        System.out.println(sets);




    }
}
