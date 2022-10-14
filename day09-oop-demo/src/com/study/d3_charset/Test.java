package com.study.d3_charset;

import sun.nio.cs.ext.GBK;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * 目标：学会去自己进行文字的编码和解码，为以后可能用的常见做准备
 */
public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // 1、编码：把文字转换成字节（使用指定的编码）
        String name = "abc我爱你中国";
        byte[] bytes = name.getBytes(); // 以当前代码默认字符集进行编码(UTF-8)
        System.out.println(Arrays.toString(bytes));

        String arr = "我爱你";
        byte[] bytes1 = arr.getBytes();
        System.out.println(Arrays.toString(bytes1));

        String arr1 = "我爱你老婆";
        byte[] bytes2 = arr1.getBytes("GBK");   // 指定GBK编码
        System.out.println(Arrays.toString(bytes2));


        // 2、解码：把字节转换成对应的中文形式（编码前 和 编码后的字符集必须一致，否则乱码）
        String rs = new String(bytes);
        System.out.println(rs); // 默认UTF-8

        String rs1 = new String(arr);
        System.out.println(rs1);

        String rs2 = new String(arr1);
        System.out.println(rs2);
    }
}
