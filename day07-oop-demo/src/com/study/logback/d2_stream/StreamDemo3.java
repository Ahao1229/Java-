package com.study.logback.d2_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * 目标：Stream.流的常用API
 * forEach:逐一处埋（遍历）
 * count:统计个数
 *       --long count();
 * filter:过滤元希
 *       --Stream<T>filter(Predicate<?super T>predicate)
 * limit:取前几个元系
 * skip:是过前几个
 * map:如工方法
 * concat:合并流.
 */
public class StreamDemo3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        list.add("张三丰");

        list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).forEach(System.out::println);

        long size = list.stream().filter(s -> s.length() == 3).count();
        System.out.println(size);

        list.stream().filter(s -> s.startsWith("张")).limit(3).forEach(System.out::println);
        list.stream().filter(s -> s.startsWith("张")).skip(2).forEach(System.out::println);

        // Map加工方法
        // 给集合元素签名都加上四方的
        list.stream().map((String s) -> "四方" + s).forEach(System.out::println);

        // 需求：把所有名称 都加工成一个对象
        list.stream().map(s -> new Student(s)).forEach(s -> System.out.println(s));

        // 合并流
        Stream<String> s1 = list.stream().filter(s -> s.startsWith("张"));
        Stream<String> s2 = Stream.of("Java1" , "Java2" );
        Stream<String> s3 = Stream.concat(s1 , s2);
        s3.forEach(s -> System.out.println(s3));

    }
}
