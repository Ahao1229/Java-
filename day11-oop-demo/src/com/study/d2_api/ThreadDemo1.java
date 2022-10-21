package com.study.d2_api;

public class ThreadDemo1 {
    public static void main(String[] args) {
        Thread t1 = new MyThread("1号");
//        t1.setName("1号");  // set方法设置名字
        t1.start();
        System.out.println(t1.getName());

        Thread t2 = new MyThread("2号");
//        t2.setName("2号");  // set方法设置名字
        t2.start();
        System.out.println(t2.getName());

        // 哪个线程执行它，它就得到哪个线程对象（当前线程对象）
        Thread m = Thread.currentThread();
        System.out.println(m.getName());

        for (int i = 0; i < 5; i++) {
            System.out.println("main输出：" + i);
        }

    }
}
