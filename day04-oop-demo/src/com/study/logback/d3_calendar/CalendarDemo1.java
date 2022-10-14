package com.study.logback.d3_calendar;

import java.util.Calendar;
import java.util.Date;

public class CalendarDemo1 {
    public static void main(String[] args) {
        // 1、拿到系统此刻的日历对象
        Calendar cal = Calendar.getInstance();
        System.out.println(cal);

        // 2、获取日历的信息：public int get(int field):取日期中的某个字段信息。
        int year = cal.get(Calendar.YEAR);
        int mm = cal.get(Calendar.MONTH) + 1;
        int days = cal.get(Calendar.DAY_OF_YEAR);
        System.out.println(year);
        System.out.println(mm);
        System.out.println(days);

        // 3、public void set(int field, int value):修改日历的某个字段信息。
        cal.set(Calendar.HOUR , 12);
        int hour = cal.get(Calendar.HOUR);
        System.out.println(hour);

        // 4、public void add(int field, int value)：为摸个字段增加/减少指定的值
        // 请问64天后是什么日子
        cal.add(Calendar.DAY_OF_YEAR , 64);
        cal.add(Calendar.MINUTE , 59);

        // 5、public final Date getTime() ：拿到此刻的日期对象
        Date d = cal.getTime();
        System.out.println(d);

        // 6、public long getTimeInmillis()：拿到此刻时间的毫秒值
        long time = cal.getTimeInMillis();
        System.out.println(time);



    }
}
