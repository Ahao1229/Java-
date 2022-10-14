package com.study.logback.d8_map_impl;

import java.util.*;

public class mapTest4 {
        public static void main(String[] args) {
                // 1、记录每个学生选择的情况
                // 使用一个Map集合存储
                Map<String , List<String> > data = new HashMap<>();

                // 2、把学生选择的数据存入进去
                List<String> selects = new ArrayList<>();
                Collections.addAll(selects , "A" , "C");
                data.put("罗勇",selects);
                System.out.println(data);

                List<String> selects1 = new ArrayList<>();
                Collections.addAll(selects1 , "B" , "C" , "D");
                data.put("胡桃",selects1);
                System.out.println(data);

                List<String> selects2 = new ArrayList<>();
                Collections.addAll(selects2 , "A" , "B" , "C" , "D");
                data.put("刘军",selects2);
                System.out.println(data);

                // 3、统计每个景点选择的人数
                Map<String , Integer> infos = new HashMap<>();

                // 4、提取所有人选择的景点的信息
                Collection<List<String>> values = data.values();
                System.out.println(values);
                // values = [[A,B,C,D] , [B,C,D] [A,C]]

                for (List<String> value : values) {
                        for (String s : value) {
                                if (infos.containsKey(s)){
                                        infos.put(s , infos.get(s) + 1);
                                }else {
                                        infos.put(s , 1);
                                }
                        }
                }
                System.out.println(infos);

        }
}
