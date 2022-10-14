package com.study.logback.d6_regex;

/**
 *  目标：正则表达式在方法中的应用
 *  public String[] spilt(String regex):
 *          -- 按照正则表达式匹配的内容进行分割字符串，返回一个字符串数组
 *  public String reploceAll(String regex,String newStr)
 *          -- 按照正则表达式匹配的内容进行替换
 */
public class RegexDemo4 {
    public static void main(String[] args) {
        String names = "小李adsnkjsd飞子sakdfjksd嘎嘎";
        String[] arrs =names.split("\\w+"); // 去除\\w
        for (int i = 0; i < arrs.length; i++) {
            System.out.println(arrs[i]);
        }
        String names2 = names.replaceAll("\\w+"," "); // 把 \\w 替换为 空格
        System.out.println(names2);
    }
}
