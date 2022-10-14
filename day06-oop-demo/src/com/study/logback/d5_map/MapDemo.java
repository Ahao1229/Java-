package com.study.logback.d5_map;

import java.util.*;

/**
 *  目标：认识Map体系的特点：按照键无序，不重复，无索引。值不要求
 */
public class MapDemo {
    public static void main(String[] args) {
        // 1、创建一个Map集合对象
        Map<String,Integer> maps = new HashMap<>(); // HashMap：元素键是无序，不重复，无索引
//        Map<String,Integer> maps = new LinkedHashMap<>(); // LinkedHashMap：键 有序，不重复，无索引       TreeMap 排序，不重复，无索引
        maps.put("iphoneX",10);
        maps.put("娃娃",31);
        maps.put("huawei",1000);
        maps.put("iphoneX",100); // 会覆盖前面的
        maps.put("生活用品",10);
        maps.put("手表",10);
        System.out.println(maps);

        // 2、清空集合
//        maps.clear();
//        System.out.println(maps);

        //3.判断集合是否为空，为空返回trUe,反之！
        System.out.println(maps.isEmpty());

        //4.根据键获取对应值：public V get(Object key)
        Integer key = maps.get("huawei");
        System.out.println(key);
        System.out.println(maps.get("iphoneX"));
        System.out.println(maps.get("iphoneXs"));

        //5.根据键删除整个元素。（删除键会返回键的值）
        System.out.println(maps.remove("生活用品"));
        System.out.println(maps);

        //6.判断是否包含某个键，包含返回true,反之
        System.out.println(maps.containsKey("娃娃"));
        System.out.println(maps.containsKey("生活用品"));

        //7.判断是否包含某个值。
        System.out.println(maps.containsValue(100));
        System.out.println(maps.containsValue(10));
        System.out.println(maps.containsValue(22));

        //8.获取全部键的集合：public Set<K> keySet()
        Set<String> keys = maps.keySet();
        System.out.println(keys);
        System.out.println(maps.keySet());

        System.out.println("---------------------------------");

        //9.获取全部值的集合：Collection<V> valves();
        Collection<Integer> values = maps.values();
        System.out.println(values);

        //10.集合的大小
        System.out.println(maps.size());

        //11.合并其他Map集合。（拓展）
        Map<String , Integer> map1 = new HashMap<>();
        map1.put("java1",1);
        map1.put("java2",100);
        Map<String , Integer> map2 = new HashMap<>();
        map2.put("java2" , 1);
        map2.put("java3" , 100);
        map1.putAll(map2);
        System.out.println(map1);
        System.out.println(map2);


    }

}
