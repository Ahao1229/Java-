package com.study.logback.d6_regex;

public class RegexDemo2 {
    // public boolean matcher(String regex):判断是否与正则表达式匹配，匹配返回true
    public static void main(String[] args) {
        // 只能是a b c
        System.out.println("a".matches("[abc]"));
        System.out.println("z".matches("[abc]"));

        // 不能出现 a b c
        System.out.println("a".matches("[^abc]"));
        System.out.println("c".matches("[^abc]"));

        System.out.println("a".matches("\\d"));
        System.out.println("2".matches("\\d"));
        System.out.println("222".matches("\\d")); // 错误，默认只能匹配一个字符
        System.out.println("z".matches("\\w")); // true，，英文字母、数字、下划线
        System.out.println("2".matches("\\w")); // true
        System.out.println("21".matches("\\w")); // false
        System.out.println("你".matches("\\w")); // false
        System.out.println("你".matches("\\W")); //true
        System.out.println("--------------------------------------");

        // 校验密码
        // 必须是数字 字母 下划线 至少6位
        System.out.println("2242fsfsfs".matches("\\w{6,}"));
        System.out.println("224f".matches("\\w{6,}"));

        // 验证码 必须是数字和字符 必须是4位
        System.out.println("23dF".matches("[a-zA-Z0-9]{4}"));
        System.out.println("23_F".matches("[a-zA-Z0-9]{4}"));
        System.out.println("23dF".matches("[\\w&&[^_]]{4}"));
        System.out.println("23_F".matches("[\\w&&[^_]]{4}"));


    }
}
