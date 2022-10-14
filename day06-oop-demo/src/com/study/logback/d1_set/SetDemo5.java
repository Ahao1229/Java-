package com.study.logback.d1_set;

import java.util.Set;
import java.util.TreeSet;

/**
 *  目标：观察TreeSet对于有值特性的数据如何排序
 *  学会对自定义类型的对象进行指定规则排序
 */
public class SetDemo5 {
    public static void main(String[] args) {
        Set<Integer> sets = new TreeSet<>();
        sets.add(23);
        sets.add(24);
        sets.add(18);
        sets.add(2);
        System.out.println(sets);



        Set<String> sets1 = new TreeSet<>();
        sets1.add("Java");
        sets1.add("About");
        sets1.add("Python");
        sets1.add("angela");
        sets1.add("四方");
        sets1.add("UI");
        sets1.add("UI");
        System.out.println(sets1);

        System.out.println("-------------------------");
        // 方式二：集合自带比较器对象进行规则定制
//        Set<Apple> apples = new TreeSet<>(new Comparator<Apple>() {
//            @Override
//            public int compare(Apple o1, Apple o2) {
//                return o2.getWeight() - o1.getWeight() >= 0 ? 1 : -1;
//            }
//        });
        Set<Apple> apples = new TreeSet<>((Apple o1, Apple o2) -> (o2.getWeight() - o1.getWeight() >= 0 ? 1 : -1));








        apples.add(new Apple("红富士","红色",9.9,500));
        apples.add(new Apple("菠萝","黄色",25.9,800));
        apples.add(new Apple("桃子","粉红色",15.9,500));
        apples.add(new Apple("葡萄","紫色",19.9,700));
        System.out.println(apples);










    }
}
