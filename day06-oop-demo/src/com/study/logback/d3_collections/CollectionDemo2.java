package com.study.logback.d3_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionDemo2 {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>(); // 可以重复！
        apples.add(new Apple("红富士","红色",9.9,500));
        apples.add(new Apple("菠萝","黄色",25.9,800));
        apples.add(new Apple("桃子","粉红色",15.9,500));
        apples.add(new Apple("葡萄","紫色",19.9,700));

        Collections.sort(apples); // 可以排序，因为Apple类重写了比较规则
        System.out.println(apples);


        // 方法二：
        Collections.sort(apples, ( o1,  o2) -> Double.compare(o1.getPrice() , o2.getPrice()));
        System.out.println(apples);
    }
}
