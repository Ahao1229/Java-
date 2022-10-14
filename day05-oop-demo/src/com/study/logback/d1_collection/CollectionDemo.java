package com.study.logback.d1_collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 *  目标：明确Collection集合体系的特点
 */
public class CollectionDemo {
    public static void main(String[] args) {
        // 有序 可重复 有索引
        Collection list = new ArrayList(); // 多态的写法
        list.add("Java");
        list.add("Java");
        list.add("Mybaits");
        list.add(23);
        list.add(23);
        list.add(false);
        list.add(false);
        System.out.println(list);

        // 无序 不重复 无索引
        Collection list1 = new HashSet(); // 多态的写法
        list1.add("Java1");
        list1.add("Java1");
        list1.add("Mybaits1");
        list1.add(231);
        list1.add(231);
        list1.add(false);
        list1.add(false);
        System.out.println(list1);

        System.out.println("------------------------------------");
        Collection<String> list2 = new ArrayList<>();
        list2.add("Java");
        list2.add("四方");
        System.out.println(list2 );

        // 集合和泛型不支持基本数据类型，只能支持引用数据类型
        Collection<Integer> list3 = new ArrayList<>();
        list3.add(23);
        list3.add(2);
        list3.add(3);
        list3.add(123);
        list3.add(234);
        System.out.println(list3);


    }
}
