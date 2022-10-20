package com.study.d4transfer_stream;
/**
 * 字符转换流
 */

import java.io.*;

public class InputStreamReaderDemo1 {
    public static void main(String[] args) throws Exception {
        // 1、提取GBK文件的原始字节流
        InputStream is = new FileInputStream("day10-oop-demo/src/GBK.txt");
        // 2、把原始字节流转换成字符输入流
//        Reader isr = new InputStreamReader(is); // 默认UTF-8的方式转换成字符流，还是会乱码;
        Reader isr = new InputStreamReader(is , "GBK"); // 以指定的GBK编码转换成字符输入流  完美解决乱码问题
        // 3、包装成缓冲流然后按行读取
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }
    }
}