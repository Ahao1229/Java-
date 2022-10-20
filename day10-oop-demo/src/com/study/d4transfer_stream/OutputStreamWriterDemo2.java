package com.study.d4transfer_stream;

import java.io.*;

/**
 * 字符输出转换流
 */
public class OutputStreamWriterDemo2 {
    public static void main(String[] args) throws Exception {
        // 1、定义一个字节输出流;
        OutputStream os = new FileOutputStream("day10-oop-demo/src/out07.txt");

        // 2、把原始的字节输出流转换成字符输出流
//        Writer isw = new OutputStreamWriter(os);    // 以默认的UTF-8写字符出去 跟直接写FileWriter一样
        Writer isw = new OutputStreamWriter(os, "GBK");    // 指定GBK编码写字符出去

        // 3、把低级的字符输出流包装成高级的缓冲字符输出流
        BufferedWriter bw = new BufferedWriter(isw);
        bw.write("我爱你中国！~~");
        bw.write("我爱你河北！~~");
        bw.write("我爱你邢台！~~");

        bw.close();
    }
}
