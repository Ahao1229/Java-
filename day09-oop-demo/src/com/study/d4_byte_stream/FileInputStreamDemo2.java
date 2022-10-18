package com.study.d4_byte_stream;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 *  目标：使用文件字节输入流每次读取一个字节数组的数据
 */
public class FileInputStreamDemo2 {
    public static void main(String[] args) throws Exception {
        // 1、创建一个文件字节流入管道与源文件接通
        InputStream is = new FileInputStream("day09-oop-demo/src/com/study/data02.txt");
        // 2、定义一个字节数组，用来读取字节数据
        byte[] buffer = new byte[3]; // 后续开发一般都是1024 1KB
        int len ; // 记录每次读取的字节数
        // 3、改进使用循环，每次读取一个字节数组
        while ((len = is.read(buffer)) != -1){
            //用多少取多少
            System.out.print(new String(buffer , 0 , len));
        }
    }
}
