package com.study.logback.d7_map_test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class mapTest1 {
        public static void main(String[] args) {
                // 1、把80个学生选择的数据拿出来
                String[] select = {"A" , "B" , "C" , "D"};
                StringBuilder sb = new StringBuilder();
                Random r = new Random();
                for (int i = 0; i < 80 ; i++) {
                        sb.append(select[r.nextInt(select.length)]);
                }
                System.out.println(sb);

                // 2、定义一个Map集合，记录最终统计的结果：
                Map<Character , Integer> infos = new HashMap<>();

                // 3、遍历80个学生选择的数据
                for (int i = 0; i < sb.length(); i++) {
                        // 4、提取当前断则的景点字符
                        char ch = sb.charAt(i);
                        // 5、判断Map集合中是否存在这个键
                        if (infos.containsKey(ch)){                    //containsKey()查看是否存在这个键值
                                // 让其值+1
                                infos.put(ch , infos.get(ch) + 1);
                        }else {
                                // 说明此景点是第一次被选
                                infos.put(ch , 1);
                        }
                }
        }
}
