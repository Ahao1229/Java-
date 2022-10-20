package com.study.d1_create;

/**
 *  目标：用匿名内部类方式实现线程的创建方式二
 */
public class TreadDemo2Other {
    public static void main(String[] args) {
        // 3、创建一个任务对象
        Runnable target = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("子线程执行输出：" + i);
                }
            }
        };
        // 4、把任务对象交给Thread处理
        Thread t = new Thread(target);
        // 5、启动线程
        t.start();

        // 简化一：
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("子线程111执行输出：" + i);
                }
            }
        }).start();

        // 简化二：
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("子线程222执行输出：" + i);
            }
        }).start();

        for (int i = 0; i < 10; i++) {
            System.out.println("主线程执行输出：" + i);
        }
    }
}


