package com.study.d8_threadpool;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    private int n;

    public MyCallable(int n) {
        this.n = n;
    }

    /**
     * 2、重写call方法
     */
    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum += i;
        }
        return Thread.currentThread().getName() + "执行1-" + n + "的和。结果是：" + sum;
    }
}