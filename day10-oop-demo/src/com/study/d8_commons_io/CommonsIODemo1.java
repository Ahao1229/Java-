package com.study.d8_commons_io;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CommonsIODemo1 {
    public static void main(String[] args) throws Exception{
        // 1、完成文件的复制
        IOUtils.copy(new FileInputStream("day10-oop-demo/src/CopyData05.txt"),
                new FileOutputStream("day10-oop-demo/src/CopyData06.txt"));
        // 2、完成文件复制到文件夹下
        FileUtils.copyFileToDirectory(new File("day10-oop-demo/src/CopyData05.txt"),
                new File("day10-oop-demo/new/"));
        // 3、完成文件夹复制到某个文件夹下
        FileUtils.copyDirectoryToDirectory(new File("day10-oop-demo/new") , new File("day10-oop-demo/new1"));
        // 4、删除文件夹
        FileUtils.deleteDirectory(new File("day10-oop-demo/new1"));
    }
}
