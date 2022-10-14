package com.study.logback.d5_integer;

/**
 *  目标：明白包装类的概念，并使用
 */
public class Test {
    public static void main(String[] args) {
        int a = 10;
        Integer a1 = 11;
        Integer a2 = a; // 没问题，，自动装箱
        int a3 = a1; // 没问题，自动拆箱
        System.out.println(a);
        System.out.println(a1);

        double db = 99.5;
        Double db1 = db; // 自动装箱
        double db2 = db1; // 自动拆箱
        System.out.println(db2);

        // int age = null; 报错，null是给引用类型的
        Integer age = null; // 不报错，因为Integer是引用类型

        System.out.println("----------------------");
        // 1、包装类可以把基本类型的数据转换成字符串形式(没啥用，装杯好用）
        Integer i3 = 23;
        String rs = i3.toString();
        String rs1 = Integer.toString(i3);
        System.out.println(rs + 1);
        System.out.println(rs1 + 1);

        // 可以直接+字符串得到字符串类型
        String rs2 = i3 + "";
        System.out.println(rs2 + 1);

        System.out.println("----------------------");
        // 2、包装类库把字符串类型的数字转换成整型或者浮点型(非常好用，非常有用！！！)
        String number = "23";
        String sco = "99.1";
        // 转换成整数        第一种方法：parseInt  or  parseDouble
        int age1 = Integer.parseInt(number);
        System.out.println(age1 + 1);
        double score = Double.parseDouble(sco);
        System.out.println(score + 0.1);

        String num = "20";
        String sco1 = "99.9";
        // 转换成整数        第二种方法：valueOf
        int age2 = Integer.valueOf(num);
        double score1 = Double.valueOf(sco1);
        System.out.println(age2 + 1);
        System.out.println(sco1 + 0.1);




    }
}
