package com.study.logback.d8_lambda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Pageable;
import java.util.Arrays;

public class LambdaDemo3 {
    public static void main(String[] args) {
        Integer[] age1 = {34, 12, 42, 23};

        Arrays.sort(age1,( o1,  o2 ) -> o2 - o1);
        // 降序);
        System.out.println(Arrays.toString(age1));
//        Arrays.sort(age1,( o1,  o2 ) -> {
//            return o2 - o1;  // 降序
//        });

        System.out.println("------------------");
        JFrame win = new JFrame("登录界面");

        JButton btn = new JButton("我是一个很大的按钮");
//        btn.addActionListener((ActionEvent e) ->{
//                System.out.println("有人点我，点我点我！！");
//
//        });
        btn.addActionListener( e -> System.out.println("有人点我，点我点我！！"));
        win.setSize(400,300);
        win.add(btn);
        win.setVisible(true);


    }
}
