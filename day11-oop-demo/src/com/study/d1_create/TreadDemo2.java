package com.study.d1_create;

/**
 *  目标：学会线程的创建方式二，理解他的优缺点
 */
public class TreadDemo2 {
    public static void main(String[] args) {
        // 3、创建一个任务对象
        Runnable target = new MyRunnable();
        // 4、把任务对象交给Thread处理
        Thread t = new Thread(target);
        // 5、启动线程
        t.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("主线程执行输出：" + i);
        }
    }
}


/**
 *  1、定义UI个线程任务猎，实现Runnable接口
 */
class MyRunnable implements Runnable{
    /**
     *  2、重写run方法，定义线程的执行任务
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程执行输出：" + i);
        }
    }
}