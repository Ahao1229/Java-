package com.study.logback.d2_collection_api;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo {
    public static void main(String[] args) {
        // HashSet：添加的元素是无序的，不重复，无索引
        Collection<String> c = new ArrayList<>();
        // 1、添加元素，添加成功返回true
        c.add("Java");
        c.add("HTML");
        c.add("MySQL");
        c.add("Java");
        c.add("四方");
        System.out.println(c.add("HTML"));
        System.out.println(c);

        // 2、清空集合元素
//        c.clear();
//        System.out.println(c);

        // 3、判断几个是否为空，为空返回true
        System.out.println(c.isEmpty());

        // 4、获取集合大小
        System.out.println(c.size());

        // 5、判断集合中是否存在某个元素
        System.out.println(c.contains("Java"));
        System.out.println(c.contains("java"));

        // 6、删除某个元素
        System.out.println(c.remove("Java")); // 默认只删除第一次出现的Java
        System.out.println(c);

        // 7、把集合转换成成数组
        Object[] arrs = c.toArray();

        System.out.println("-----------------拓展-------------------");
        Collection<String> c1 = new ArrayList<>();
        c1.add("java1");
        c1.add("java2");
        System.out.println(c1);
        Collection<String> c2 = new ArrayList<>();
        c2.add("赵敏");
        c2.add("殷素素");
        // addAll把c2集合的元素全部导入到c1中去
        c1.addAll(c2);
        System.out.println(c1);
        System.out.println(c2);



    }
}
