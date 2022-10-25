package com.study.d8_threadpool;

import java.util.concurrent.*;

/**
 *  目标：自定义一个线程池对象，并测试其性能
 */
public class ThreadPoolDemo2 {
    public static void main(String[] args) throws Exception {
        // 1、创建线程池对象
        ExecutorService pool = new ThreadPoolExecutor(3, 5,
                6, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5),
                Executors.defaultThreadFactory() , new ThreadPoolExecutor.AbortPolicy());

        // 2、给任务线程池处理
       Future<String> f1 = pool.submit(new MyCallable(100));
       Future<String> f2 = pool.submit(new MyCallable(200));
       Future<String> f3 = pool.submit(new MyCallable(300));
       Future<String> f4 = pool.submit(new MyCallable(400));

        System.out.println(f1.get());
        System.out.println(f2.get());
        System.out.println(f3.get());
        System.out.println(f4.get());

    }
}
