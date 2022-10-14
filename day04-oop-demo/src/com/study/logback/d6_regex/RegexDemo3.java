package com.study.logback.d6_regex;

import java.util.Scanner;

public class RegexDemo3 {
    public static void main(String[] args) {
        // 目标：校验 手机号码 邮箱 电话号码
        checkPhone();
        checkEmail();
        checkTel();
    }

    public static void checkTel(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入您注册的电话号码");
            String tel = sc.next();
            // 判断手机号码的格式是否正确
            if (tel.matches("0\\d{2,6}-?\\d{5,20}")){
                System.out.println("电话号码格式正确：注册完成");
                break;
            }else {
                System.out.println("格式有误！");
            }
        }
    }





    public static void checkEmail(){
        Scanner sc = new Scanner(System.in);

        // 判断手机号码的格式是否正确
        while (true) {
            System.out.println("请输入您注册的邮箱");
            String email = sc.next();
            if (email.matches("\\w{1,30}@[a-zA-Z0-9]{2,20}(\\.[a-zA-Z0-9]{2,20}){1,2}")){
                System.out.println("邮箱格式正确：注册完成");
                break;
            }else {
                System.out.println("格式有误！");
            }
        }
    }




    public static void checkPhone(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入您注册的手机号码");
            String phoneNum = sc.next();
            // 判断手机号码的格式是否正确
            if (phoneNum.matches("1[3-9]\\d{9}")){
                System.out.println("手机号码格式正确：注册完成");
                break;
            }else {
                System.out.println("格式有误！");
            }
        }
    }
}
