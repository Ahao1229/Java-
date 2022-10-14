package com.study.d1_file;

import java.io.File;
import java.io.IOException;

public class FileDemo3 {
    public static void main(String[] args) throws IOException {
        // a、创建一个新文件，创建成功返回true     几乎不用
        File f = new File("day09-oop-demo/src/data.txt");
        System.out.println(f.createNewFile());
        File f1 = new File("day09-oop-demo/src/data2.txt");
        System.out.println(f1.createNewFile());
        
        // b、mkdir创建一级目录
        File f2 = new File("C:\\Users\\h'p\\Desktop\\喜多川\\aaa");
        System.out.println(f2.mkdir());

        // c、mkdirs创建多及目录
        File f3 = new File("C:\\Users\\h'p\\Desktop\\喜多川\\aaa\\bbb\\ccc\\eee");
        System.out.println(f3.mkdirs());

        // d、删除文件或者空文件夹
        System.out.println(f1.delete());
        File f4 = new File("C:\\Users\\h'p\\Desktop\\喜多川\\123.txt");
        System.out.println(f4.createNewFile());
        System.out.println(f4.delete()); // 占用一样可以删除

        // f、只能删除空文件夹，不能删除非空文件夹
        File f5 = new File("C:\\Users\\h'p\\Desktop\\喜多川\\bbb");
        System.out.println(f5.mkdir());
        System.out.println(f5.delete());


    }
}
