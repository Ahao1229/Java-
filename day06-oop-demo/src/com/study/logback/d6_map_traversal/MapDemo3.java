package com.study.logback.d6_map_traversal;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class MapDemo3 {
    public static void main(String[] args) {
        Map<String,Integer> maps = new HashMap<>(); // HashMap：元素键是无序，不重复，无索引
//        Map<String,Integer> maps = new LinkedHashMap<>(); // LinkedHashMap：键 有序，不重复，无索引       TreeMap 排序，不重复，无索引
        maps.put("娃娃",31);
        maps.put("huawei",1000);
        maps.put("iphoneX",100); // 会覆盖前面的
        maps.put("生活用品",10);
        maps.put("手表",10);
        System.out.println(maps);

        maps.forEach((k, v) -> System.out.println(k + "----->" + v));
//        maps.forEach(new BiConsumer<String, Integer>() {
//            @Override
//            public void accept(String key, Integer value) {
//                System.out.println(key + "----->" + value);
//            }
//        });










    }
}
