package com.study.logback.d4_jdk8_time;

import java.time.LocalDate;
import java.time.Period;

public class Demo4Period {
    public static void main(String[] args) {
        // 当前本地 年月日
        LocalDate today = LocalDate.now();
        System.out.println(today);

        // 生日的年月日
        LocalDate birthday = LocalDate.of(2020,9,25);
        System.out.println(birthday);

        Period period  = Period.between(birthday, today);
        System.out.println(period.getYears() + "年");
        System.out.println(period.getMonths() + "月");
        System.out.println(period.getDays() + "日");
    }
}
