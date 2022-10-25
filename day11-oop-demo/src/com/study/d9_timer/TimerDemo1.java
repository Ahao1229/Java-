package com.study.d9_timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 目标：Timer定时器的使用和了解
 */
public class TimerDemo1 {
    public static void main(String[] args) {
        // 1、创建Timer定时器
        Timer timer = new Timer(); // 定时器本身是个单线程
        // 2、调用方法：处理定时任务
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行一次~~");
            }
        }, 3000, 2000);
    }
}
