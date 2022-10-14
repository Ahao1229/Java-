package com.study.d1_file;

import java.io.File;

/**
 *  目标：学会创建File对象定位操作系统的文件
 */
public class FileDemo {
    public static void main(String[] args) {
        // 1、创建File对象
        // 路径写法
//        C:/Users/h'p\Desktop/喜多川/succubus.jpg 也可
        File f = new File("C:\\Users\\h'p\\Desktop\\喜多川\\succubus.jpg");
        long size = f.length(); // 文件的字节大小
        System.out.println(size);


        // 2、File创建对象，支持绝对路径    也支持相对路径
        File f2 = new File("day09-oop-demo/src/data.txt");
        System.out.println(f2.length());

        // 3、File创建对象，可以是文件也可以是文件夹
        File f3 = new File("C:\\Users\\h'p\\Desktop\\喜多川");
        System.out.println(f3.exists()); // 判断这个路径是否存在，这个文件夹是否存在
    }
}
