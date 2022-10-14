package com.study.logback.d8_map_impl;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo2 {
    public static void main(String[] args) {
        // 1、创建一个Map集合对象
        Map<String, Integer> maps =new LinkedHashMap<>();
        maps.put("鸿星尔克",1);
        maps.put("Java",1);
        maps.put("枸杞",100);
        maps.put("Java",100);
        maps.put(null,null);
        System.out.println(maps);
    }
}
