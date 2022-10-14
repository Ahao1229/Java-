package com.study.logback.d6_regex;

public class RegexDemo1 {
    public static void main(String[] args) {
        // 需求：校验qq号码，必须全部数字6 - 20位
        System.out.println(checkQQ("251425998"));
        System.out.println(checkQQ("251425a98"));
        System.out.println(checkQQ(null));
        System.out.println(checkQQ("123"));

        // 正则表达式初体验
        System.out.println("-------------------");
        System.out.println(checkQQ2("25142259"));
        System.out.println(checkQQ2("25142a64"));
        System.out.println(checkQQ2("251"));
        System.out.println(checkQQ2(null));

    }
    public static boolean checkQQ2(String qq){
        return qq != null && qq.matches("\\d{6,20}");
    }





    public static boolean checkQQ(String qq){
        // 1、判断QQ号的长度是否满足要求
        if (qq == null || qq.length() < 6 || qq.length() > 20){
            return false;
        }

        // 2、判断qq中是否全部是数字
        // 251425a87
        for (int i = 0; i < qq.length(); i++) {
            // 获取每个字符
            char ch = qq.charAt(i);
            // 判断这个字符是否是数字，不是数字直接返回false
            if (ch < '0' || ch > '9'){
                return false;
            }
        }
        return true;
    }
}
