package com.study.logback.d7_genericity;

import java.util.ArrayList;
import java.util.List;

public class GenericityDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Java2");

        List<String> list1 = new ArrayList();
        list1.add("Java");

        list1.add("Spring");

        for (Object o : list1) {
            System.out.println(o);
        }

        System.out.println("---------------------");
        List<Object> list2 = new ArrayList<>();
        list2.add(23);
        list2.add(23.3);
        list2.add("Java");











    }
}
