package com.study.d6_thread_sychronized_lock;

/**
 * 取钱线程类
 */
public class DrawThread extends Thread{
    // 接受处理的账户对象
    private Account acc;
    public DrawThread(Account acc , String name){
        super(name);
        this.acc = acc;
    }
    @Override
    public void run() {
        // 小明 小红 取钱
        acc.drawMoney(100000.0);
    }
}
