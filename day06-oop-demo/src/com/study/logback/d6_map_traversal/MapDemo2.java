package com.study.logback.d6_map_traversal;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo2 {
    public static void main(String[] args) {

        Map<String,Integer> maps = new HashMap<>(); // HashMap：元素键是无序，不重复，无索引
//        Map<String,Integer> maps = new LinkedHashMap<>(); // LinkedHashMap：键 有序，不重复，无索引       TreeMap 排序，不重复，无索引
        maps.put("娃娃",31);
        maps.put("huawei",1000);
        maps.put("iphoneX",100); // 会覆盖前面的
        maps.put("生活用品",10);
        maps.put("手表",10);
        System.out.println(maps);
        // 1、把Map集合转换成Set集合
        Set<Map.Entry<String, Integer>> entries = maps.entrySet(); //ctrl + alt + v 自动填写
        // 2、开始遍历
        for (Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println(key + "---->" + value);
        }

    }
}
