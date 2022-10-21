package com.study.d7_thread_comunication;

public class DepositThread extends Thread{
    private Account acc;

    public DepositThread(Account acc , String name){
        super(name);
        this.acc = acc;
    }

    @Override
    public void run() {
        while (true) {
            // 亲爹 干爹 养爹     不断存钱
            acc.deposit(100000);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
