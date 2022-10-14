package com.study.logback.d4_jdk8_time;

import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.MonthDay;
import java.util.Locale;

public class Demo01LocalDate {
    public static void main(String[] args) {
        // 1、获取本地日期对象
        LocalDate nowDate = LocalDate.now();
        System.out.println("今天：" + nowDate);

        int year = nowDate.getYear();
        System.out.println("今年：" + year);

        int month = nowDate.getMonthValue();
        System.out.println("本月：" + month);

        int day = nowDate.getDayOfMonth();
        System.out.println("今天：" + day);

        // 当年第几天
        int dayOfYear = nowDate.getDayOfYear();
        System.out.println("当年第几天：" + dayOfYear);

        // 星期
        System.out.println(nowDate.getDayOfWeek());
        System.out.println(nowDate.getDayOfWeek().getValue());

        // 月份
        System.out.println(nowDate.getMonth());
        System.out.println(nowDate.getMonth().getValue());

        System.out.println("--------------------");
        LocalDate bt = LocalDate.of(1991,11,11);
        System.out.println(bt);
        System.out.println(LocalDate.of(2022, 9, 29));

        System.out.println("--------------------");
        LocalTime nowTime = LocalTime.now();
        System.out.println();

        // 判断今天是否是你的生日
        LocalDate birthday = LocalDate.of(2002,02,10);
        LocalDate nowDate1 = LocalDate.now();

        MonthDay birMd = MonthDay.of(birthday.getMonthValue() , birthday.getDayOfMonth());
        MonthDay nowMd = MonthDay.from(nowDate1);
        System.out.println("今天是你生日吗？" + birMd.equals(nowMd));
    }
}
