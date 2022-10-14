package com.study.d1_file;

import java.io.File;
import java.text.SimpleDateFormat;

public class FileDemo2 {
    public static void main(String[] args) {
        File f = new File("day09-oop-demo/src/data.txt");
        // a、获取他的绝对路径
        System.out.println(f.getAbsoluteFile());
        // b、获取文件定义的时候使用的路径
        System.out.println(f.getPath());
        // c、获取文件的名称，带后缀
        System.out.println(f.getName());
        // d、获取文件的大小：字节个数
        System.out.println(f.length());
        // e、获取文件最后修改的时间
        long time1 = f.lastModified();
        System.out.println("最后的修改时间：" + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(time1));
        // f、判断文件是文件还是文件夹
        System.out.println(f.isFile()); // true
        System.out.println(f.isDirectory()); // false

    }
}
