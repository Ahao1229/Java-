package com.study.d7_thread_comunication;

public class DrawThread extends Thread{
    private Account acc;

    public DrawThread(Account acc , String name){
        super(name);
        this.acc = acc;
    }

    @Override
    public void run() {
        while (true) {
            // 小明 小红 不断取钱
            acc.drawMoney(100000);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
