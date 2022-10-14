package com.study.logback.d9_api_object;

public class Test2 {
    public static void main(String[] args) {
        Student s1 = new Student("周雄",'男',19);
        Student s2 = new Student("周雄",'男',19);

        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);
    }
}
