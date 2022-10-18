package com.study.d6_char_stream;

import java.io.FileReader;
import java.io.Reader;

public class FileReaderDemo2 {
    public static void main(String[] args) throws Exception{
        // 目标：每次读取一个字符。
        // 1、创建一个字符输入楼管道与源文件接通
        Reader fr = new FileReader("day09-oop-demo/src/Data06.txt");

        // 2、用循环，每次读取一个字符数组的数据
        char[] buffer = new char[1024]; // 1K字符
        int len;
        while ((len = fr.read(buffer)) != -1){
            String rs = new String(buffer , 0 ,len);
            System.out.println(rs);
        }

    }
}
