package com.study.d2_api;

public class ThreadDemo2 {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 5; i++) {
            System.out.println("输出：" + i);
            if (i == 2){
                // 让进程休眠
                // 段子：项目经理让我加上这行代码，如果用户愿意交钱，我就注释掉
                Thread.sleep(3000);
            }
        }
    }
}
