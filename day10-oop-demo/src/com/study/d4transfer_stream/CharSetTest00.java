package com.study.d4transfer_stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 *  演示一下代码编码与文件编码相同好人不同的情况
 */
public class CharSetTest00 {
    public static void main(String[] args) {
        try (
                // 代码是UTF-8，文件也是，不会乱码
                // 1、创建一个字符输入楼管道与源文件接通
                //Reader  fr = new FileReader("day10-oop-demo/src/CopyData05.txt");
                Reader  fr = new FileReader("day10-oop-demo/src/GBK.txt");

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
