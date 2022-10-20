package com.study.d6_printStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * 目标：学会使用打印流高效方便写数据到文件。
 */
public class PrintDemo1 {
    public static void main(String[] args) throws Exception {
        // 1、创建一个打印流对象
//        PrintStream ps= new PrintStream(new FileOutputStream("day10-oop-demo/src/ps.txt")); // 追加管道
        PrintWriter ps = new PrintWriter("day10-oop-demo/src/ps.txt"); // 覆盖管道

        ps.println(97);
        ps.println('a');
        ps.println(23.3);
        ps.println(true);
        ps.println("我是打印流输出的，我是啥就打印啥");

        ps.write("我在学习！");

        ps.close();
    }
}
