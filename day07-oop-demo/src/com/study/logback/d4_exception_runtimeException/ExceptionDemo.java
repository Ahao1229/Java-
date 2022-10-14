package com.study.logback.d4_exception_runtimeException;

import java.util.Scanner;

public class ExceptionDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            try {
                System.out.println("请输入合法的价格");
                String priceStr = sc.next();
                //转换成double类型
                double price = Double.valueOf(priceStr);

                // 判断价格是否大于0
                if (price > 0){
                    System.out.println("定价" + price);
                    break;
                }else {
                    System.out.println("价格必须为正数");
                }
            } catch (NumberFormatException e) {
                System.out.println("用户输入的数据有问题，请您输入合法字符");
            }
        }
    }

}
