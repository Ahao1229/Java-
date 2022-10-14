package com.study.logback.d3_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 目标：Collections 工具类前使用
 * java.utils.Collections:是集合L具类
 * Collections并不属于集合，是用来探作集合的工具类，
 * Collections行几个常用的API:
 * public static <T>boolean addAll(Collection<?super T>c,T...elements)
 * 给集合对象批量添加元煮！
 * -public static void shuffle(List<?>list):打乱集合领序，
 * -public static<T>void sort(List<T>List):将集合中元素按照默认规则序
 * -public static<T>void5ort(List<T>List,Comparator<?super T>c):将集合中元系按照指定规则排序，
 */
public class CollectionDemo1 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
//        names.add("楚留香");
//        names.add("胡铁花");
//        names.add("张无忌");
//        names.add("陆小凤");
        Collections.addAll(names , "楚留香","胡铁花","张无忌","陆小凤");
        System.out.println(names);

        // 2、打乱集合顺序
        Collections.shuffle(names);
        System.out.println(names);

        // 3、将集合中的元素在按照默认规则排序。
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list , 12,23,2,4);
        System.out.println(list);
        Collections.sort(list); // 升序排序
        System.out.println(list);



    }
}
