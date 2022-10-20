package com.study.d3_char_buffer;

import java.io.*;

/**
 * 目标：学会使用缓冲字符输入流提高字符输入流的性能，新增了按照行读取的方法(经典代码)
 */
public class BufferedReaderDemo1 {
    public static void main(String[] args) {
        try (
                // 1、创建一个字符输入楼管道与源文件接通
                Reader fr = new FileReader("day10-oop-demo/src/CopyData05.txt");
                // a. 把地接的字符输入流包装成高级的缓冲字符输入流
                BufferedReader br = new BufferedReader(fr);
                ) {
            // 2、用循环，独有方法每次读取一行
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
