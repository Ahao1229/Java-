package com.study.d2_recusion;

import java.io.File;

/**
 *  文件搜索  在F盘：LeagueClient.exe
 */
public class RecursionDemo4 {
    public static void main(String[] args) {
    // 2、传入目录和文件名
        searchFile(new File("F:/") , "LeagueClient.exe");
    }

    /**
     * 1、搜索某个目录下全部文件，找到我们想要的文件
     * @param dir 目录
     * @param fileName 文件名称
     */
    public static void searchFile(File dir , String fileName){
        // 3、判断dir是否是目录
        if (dir != null && dir.isDirectory()){
            // 可以找了
            // 4、提取当前目录下的一级文件对象
            File[] files = dir.listFiles();
            // 5、判断是否存在一级文件对象,存在才可以遍历
            if (files != null && files.length >0){
                for (File file : files) {
                    // 6、判断当前遍历的一级文件对象是文件还文件夹
                    if (file.isFile()){
                        // 7、是否是要找到文件，是返回路径
                        if (file.getName().contains(fileName)){
                            System.out.println("找到了：" + file.getAbsolutePath());
                        }
                    }else {
                        // 8、是文件夹递归
                        searchFile(file,fileName);
                    }
                }
            }
        }else {
            System.out.println("您当前搜索是空文件夹或者不是文件夹");
        }

    }
}
