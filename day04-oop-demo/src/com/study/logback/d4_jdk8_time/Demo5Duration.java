package com.study.logback.d4_jdk8_time;

import java.time.Duration;
import java.time.LocalDateTime;

public class Demo5Duration {
    public static void main(String[] args) {
        // 本地日期时间对象
        LocalDateTime today = LocalDateTime.now();
        System.out.println(today);

        // 纪念日的日期时间对象
        LocalDateTime Date = LocalDateTime.of(2020,9,25,20,00,00);

        System.out.println(Date);

        Duration duration = Duration.between(Date , today);
        System.out.println(duration.toDays());
        System.out.println(duration.toHours());
        System.out.println(duration.toMinutes());
        System.out.println(duration.toMillis());
        System.out.println(duration.toNanos());


    }
}
