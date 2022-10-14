package com.study.d4_byte_stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileInputStreamDemo1 {
    public static void main(String[] args) throws Exception {
        // 1、创建一个文件字节输入流管道与源文件接通
//        InputStream is = new FileInputStream(new File("day09-oop-demo/src/data.txt"));
        // 简化写法
        InputStream is = new FileInputStream("day09-oop-demo/src/data.txt");

        // 2、读取字节返回（每次一个字节太麻烦，使用循环改进）
        // 定义一个变量记录每次读取的字节
        int b;
        while ((b = is.read()) != -1){
            System.out.print((char) b);
        }
        // 这个方法无法读取中文

    }
}
