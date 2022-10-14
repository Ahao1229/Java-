package com.study.logback.d6_collection_update_delect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        // 1、准备数据
        List<String> lists = new ArrayList<>();

        lists.add("四方");
        lists.add("Java");
        lists.add("Java");
        lists.add("赵敏");
        lists.add("小昭");
        lists.add("殷素素");
        lists.add("周芷若");
        System.out.println(lists);

        // 需求：删除全部的Java信息
        // a、迭代器遍历删除
//        Iterator<String> it = lists.iterator();
//        while (it.hasNext()){
//            String ele = it.next();
//            if ("Java".equals(ele)){
//                it.remove(); // 使用迭代器删除当前所在元素，保证不后移
//            }
//        }
//        System.out.println(lists);

        // b、foreach遍历删除        不可以会出bug
//        for (String s : lists) {
//            if ("Java".equals(s)){
//                lists.remove("Java");
//            }
//        }

        // c、lambda 表达式         也会出现bug
//        lists.forEach(s -> {
//            if ("Java".equals(s)) {
//                lists.remove("Java");
//            }
//        });


        // for循环        正向删除不行 ， 倒着删可以
//        for (int i = 0; i < lists.size(); i++) {
//            String ele = lists.get(i);
//            if ("Java".equals(ele)){
//                lists.remove("Java");
//            }
//        }
        for (int i = lists.size() - 1; i >= 0; i--) {
            String ele = lists.get(i);
            if ("Java".equals(ele)) {
                lists.remove("Java");
            }
        }
        System.out.println(lists);
    }
}
