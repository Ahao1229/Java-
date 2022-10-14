package com.study.d1_file;

import java.io.File;

public class FileDemo4 {
    public static void main(String[] args) {
        // 1、定位一个目录
        File f1 = new File("C:\\Users\\h'p\\Desktop\\喜多川");
        String[] names = f1.list();
        for (String name : names) {
            System.out.println(name);
        }

        // 2、一级文件对象
        // 获取当前目录下所有的“一级文件对象”到一个文件对象数组中去返回（重点）
        File[] files = f1.listFiles();
        for (File file : files) {
            System.out.println(file.getAbsoluteFile());
        }

    }
}
