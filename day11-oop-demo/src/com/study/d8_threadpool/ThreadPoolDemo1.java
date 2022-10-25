package com.study.d8_threadpool;

import java.util.concurrent.*;

/**
 *  目标：自定义一个线程池对象，并测试其性能
 */
public class ThreadPoolDemo1 {
    public static void main(String[] args) {
        // 1、创建线程池对象
        ExecutorService pool = new ThreadPoolExecutor(3, 5,
                6, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5),
                Executors.defaultThreadFactory() , new ThreadPoolExecutor.AbortPolicy());

        // 2、给任务线程池处理
        Runnable target = new MyRunnable();
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);

        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        // 创建临时线程
        pool.execute(target);
        pool.execute(target);
        // 不创建，拒绝策略被触发！！
//        pool.execute(target);

        // 关闭线程池（开发中一般不使用）
//        pool.shutdownNow(); // 立即关闭，即使任务没有完成，丢失任务的数据
        pool.shutdown(); // 等待全部任务执行结束之后在关闭


    }
}
