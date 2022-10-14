package com.study.logback.d4_jdk8_time;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Demo6ChronoUnit {
    public static void main(String[] args) {
        // 本地日期时间对象
        LocalDateTime today = LocalDateTime.now();
        System.out.println(today);

        // 纪念日期
        LocalDateTime Date = LocalDateTime.of(2020,9,25,20,00,00);
        System.out.println(Date);
        System.out.println("年数：" + ChronoUnit.YEARS.between(Date ,today));
        System.out.println("月数：" + ChronoUnit.MONTHS.between(Date ,today));
        System.out.println("周数：" + ChronoUnit.WEEKS.between(Date ,today));
        System.out.println("天数：" + ChronoUnit.DAYS.between(Date ,today));
        System.out.println("小时数：" + ChronoUnit.HOURS.between(Date ,today));
        System.out.println("分数：" + ChronoUnit.MINUTES.between(Date ,today));
        System.out.println("秒数：" + ChronoUnit.SECONDS.between(Date ,today));
        System.out.println("毫秒数：" + ChronoUnit.MILLIS.between(Date ,today));
        System.out.println("微秒数：" + ChronoUnit.MICROS.between(Date ,today));
        System.out.println("纳秒数：" + ChronoUnit.NANOS.between(Date ,today));
        System.out.println("半天数：" + ChronoUnit.HALF_DAYS.between(Date ,today));
        System.out.println("十年数：" + ChronoUnit.DECADES.between(Date ,today));
        System.out.println("世纪数：" + ChronoUnit.CENTURIES.between(Date ,today));
        System.out.println("千年数：" + ChronoUnit.MILLENNIA.between(Date ,today));
        System.out.println("纪元数：" + ChronoUnit.ERAS.between(Date ,today));




    }
}
