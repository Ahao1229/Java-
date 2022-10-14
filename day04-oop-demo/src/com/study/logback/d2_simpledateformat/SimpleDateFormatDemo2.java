package com.study.logback.d2_simpledateformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo2 {
    public static void main(String[] args) throws ParseException {
        // 目标：学会使用SimpleDateFormat机械字符串时间成为日期对象
        // 有一个时间 2022年9月29日10:04:55往后2天14小时49分06秒后的时间是多少

        // 1、把字符串时间拿到程序中来
        String dateStr = "2022年9月29日10:07:05";

        // 2、把字符串时间解析成日期对象(重点：形式必须与被解析的时间的形式完全一样，否则运行时解析报错！！！)
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
        Date d = sdf.parse(dateStr); // 解析

        // 3、往后走2天 14小时 49分 06秒
        long time = d.getTime() + (2L*24*60*60 +14*60*60 +49*60 +6)*1000;


        // 4、格式化这个时间毫秒值就是结果
        System.out.println(sdf.format(time));

    }
}
