package com.study.d7_thread_comunication;

public class Account {
    private String cardID;
    private double money;

    public Account() {
    }

    public Account(String cardID, double money) {
        this.cardID = cardID;
        this.money = money;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    /**
     * 小明和小红 ： 取钱
     */
    public synchronized void drawMoney(double money) {
        try {
            String name = Thread.currentThread().getName();
            if (this.money >= money){
                // 钱够，可取
                System.out.println(name + "来取钱:" + money + "成功!");
                this.money -= money;
                System.out.println(name+ "取钱结束后，余额为：" + this.money);
                // 没钱了
                this.notifyAll(); // 唤醒所有线程
                this.wait(); // 锁对象，让当前线程进入等待！
            }else {
                // 钱不够不可取
                // 唤醒别人，等待自己
                this.notifyAll(); // 唤醒所有线程
                this.wait(); // 锁对象，让当前线程进入等待！
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *  亲爹 干爹 养爹
     */
    public synchronized void deposit(double money) {
        try {
            String name = Thread.currentThread().getName();
            if (this.money == 0){
                // 没钱了，存钱吧
                this.money += money;
                System.out.println(name + "存钱" + money + "成功！存钱后余额为：" + this.money);
                // 有钱了，唤醒别人，等待自己
                this.notifyAll(); // 唤醒所有线程
                this.wait(); // 当前进程进行等待
            }else {
                // 有钱不存钱
                this.notifyAll();
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
