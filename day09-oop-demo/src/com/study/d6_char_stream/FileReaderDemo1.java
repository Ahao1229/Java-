package com.study.d6_char_stream;

import java.io.FileReader;
import java.io.Reader;

public class FileReaderDemo1 {
    public static void main(String[] args) throws Exception{
        // 目标：每次读取一个字符。
        // 1、创建一个字符输入楼管道与源文件接通
        Reader fr = new FileReader("day09-oop-demo/src/CopyData05.txt");

        // 2、使用循环读取字符返回，没有可读的字符是会返回-1；
        int code;
        while ((code = fr.read()) != -1){
            System.out.print((char) code);
        }
    }
}
