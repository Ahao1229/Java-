package com.study.d3_char_buffer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

/**
 *  目标：学会缓冲字符输出流的使用，学会它多出来的一个功能：newLine();
 */
public class BufferedWriterDemo2 {
    public static void main(String[] args) throws Exception{
        // 目标：每次读取一个字符。
        // 1、创建一个字符输入楼管道与源文件接通
        // Writer fw = new FileWriter("day09-oop-demo/src/out07.txt");// 覆盖管道，每次启动都会清空文件之前的数据
        Writer fw = new FileWriter("day10-oop-demo/src/out06.txt" , true);// 追加管道，每次启动都会清空文件之前的数据
        BufferedWriter bw = new BufferedWriter(fw);


        // a. public void write(int c):写一个字符出去
        bw.write(98);
        bw.write('a');
        bw.write('李'); // 字符，不会出错
        bw.newLine(); // 换行

        // b. public void write(String c): 写一个字符串出去
        bw.write("abc我是中国人");
        bw.newLine(); // 换行

        // c. public void write(char[] buffer): 写一个字符数组出去
        char[] chars = "abc我是中国人".toCharArray();
        bw.write(chars);
        bw.newLine(); // 换行

        // d. public void write(String c , int pos ,int len): 写字符串的一部分出去
        bw.write("abc我是中国人",0,3);
        bw.write("\r\n"); // 换行

        // e. public void write(char[] buffer , int pos ,int len): 写字符数组的一部分出去
        bw.write(chars,3,5);
        bw.newLine(); // 换行

        bw.flush(); // 刷新
        bw.close(); // 关闭包含刷新


    }
}
