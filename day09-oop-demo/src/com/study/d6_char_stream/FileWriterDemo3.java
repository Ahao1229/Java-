package com.study.d6_char_stream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class FileWriterDemo3 {
    public static void main(String[] args) throws Exception{
        // 目标：每次读取一个字符。
        // 1、创建一个字符输入楼管道与源文件接通
        // Writer fw = new FileWriter("day09-oop-demo/src/out07.txt");// 覆盖管道，每次启动都会清空文件之前的数据
        Writer fw = new FileWriter("day09-oop-demo/src/out07.txt" , true);// 追加管道，每次启动都会清空文件之前的数据

        // a. public void write(int c):写一个字符出去
        fw.write(98);
        fw.write('a');
        fw.write('李'); // 字符，不会出错
        fw.write("\r\n"); // 换行

        // b. public void write(String c): 写一个字符串出去
        fw.write("abc我是中国人");
        fw.write("\r\n"); // 换行

        // c. public void write(char[] buffer): 写一个字符数组出去
        char[] chars = "abc我是中国人".toCharArray();
        fw.write(chars);
        fw.write("\r\n"); // 换行

        // d. public void write(String c , int pos ,int len): 写字符串的一部分出去
        fw.write("abc我是中国人",0,3);
        fw.write("\r\n"); // 换行

        // e. public void write(char[] buffer , int pos ,int len): 写字符数组的一部分出去
        fw.write(chars,3,5);
        fw.write("\r\n"); // 换行

        fw.flush(); // 刷新
        fw.close(); // 关闭包含刷新


    }
}
