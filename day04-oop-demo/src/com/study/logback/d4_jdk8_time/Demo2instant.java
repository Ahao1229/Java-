package com.study.logback.d4_jdk8_time;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

public class Demo2instant {
    public static void main(String[] args) {
        // 1、得到一个Instant时间戳对象
        Instant instant = Instant.now();
        System.out.println(instant);  // 输出的不是北京时间

        // 2、系统此刻的时间戳怎么办？
        Instant instant1 = Instant.now();
        System.out.println(instant1.atZone(ZoneId.systemDefault()));

        // 3、如何返回Date对象
        Date date = Date.from(instant);
        System.out.println(date);

        Instant i2 = date.toInstant();
        System.out.println(i2);


    }
}
