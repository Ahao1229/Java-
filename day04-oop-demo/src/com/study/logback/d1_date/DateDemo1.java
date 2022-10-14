package com.study.logback.d1_date;

import javax.xml.crypto.Data;
import java.util.Date;

public class DateDemo1 {
    public static void main(String[] args) {
        // 1、创建一个Date类的对象：代表系统此刻日期时间对象
        Date d = new Date();
        System.out.println(d);


        // 2、获取时间毫秒值
        long time = d.getTime();
        System.out.println(time);
//        long time1 = System.currentTimeMillis();
//        System.out.println(time1);

        System.out.println("-------------------------");
        // 1、得到当前时间毫秒值
        Date d1 = new Date();
        System.out.println(d1);
        // 2、当前时间往后走 1小时 121s
        long time2 = System.currentTimeMillis();
        time2 += (60*60 + 121) * 1000;
        // 3、把时间毫秒值转换成对应的日期对象
        Date d2 = new Date(time2);
        System.out.println(d2);


    }
}
