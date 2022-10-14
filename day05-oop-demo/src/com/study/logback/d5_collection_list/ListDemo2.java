package com.study.logback.d5_collection_list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo2 {
    public static void main(String[] args) {
        List<String> lists = new ArrayList<>();
        lists.add("1");
        lists.add("2");
        lists.add("3");

        // for循环
        System.out.println("------------------------");
        for (int i = 0; i < lists.size(); i++) {
            String ele = lists.get(i);
            System.out.println(ele);
        }

        // 迭代器
        System.out.println("------------------------");
        Iterator<String> it = lists.iterator();
        while (it.hasNext()){
            String ele = it.next();
            System.out.println(ele);
        }

        // foreach
        System.out.println("-------------------------");
        for (String ele: lists) {
            System.out.println(ele);
        }

        // lambda表达式
        System.out.println("-------------------------");
        lists.forEach(System.out::println);










    }
    }

