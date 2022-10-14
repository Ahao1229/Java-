package com.study.d2_recusion;

/**
 * 目标：啤酒2元1瓶，4个盖子可以换一瓶，2个空瓶可以换一瓶，
 * 请问10元钱可以喝多少瓶酒，剩余多少空瓶和盖子，
 * 答案：15瓶3盖子1瓶子
 */
public class RecursionDemo5 {
    // 定义一个静态的成员不安了用于存储可以买的酒的数量
    public static int totalNumber;  // 总数量
    public static int lastBottleNumber; // 记录每次剩余的瓶子个数
    public static int lastCoverNumber; // 记录每次剩余的盖子个数
    public static void main(String[] args) {
        // 1、拿钱买酒
        buy(10);
        System.out.println("总数：" + totalNumber);
        System.out.println("剩余盖子数：" + lastCoverNumber);
        System.out.println("剩余瓶子数：" + lastBottleNumber);
    }
    public static void buy(int money){
        // 2、看可以立刻买几瓶啤酒
        int buyNumber = money / 2;
        totalNumber += buyNumber;

        // 3、把瓶子和盖子换算成钱
        // 统计本轮总的盖子数和瓶子数
        int coverNumber = lastCoverNumber + buyNumber;
        int bottleNumber = lastBottleNumber + buyNumber;

        // 统计换算的总金额
        int allMoney = 0;
        if (coverNumber >= 4){
            allMoney += (coverNumber / 4) * 2;
        }
        lastCoverNumber = coverNumber % 4 ;
        if (bottleNumber >= 2){
            allMoney += (bottleNumber / 2) * 2 ;
        }
        lastBottleNumber = bottleNumber % 2;

        if (allMoney >= 2){
            buy(allMoney);
        }
    }
}
