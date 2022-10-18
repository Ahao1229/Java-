package com.study.d4_byte_stream;

import java.io.*;

/**
 *   目标：学会使用字节流完成文件的复制（支持一切文件类型的复制）
 */
public class CopyDemo5 {
    public static void main(String[] args){
        try {
            // 1、创建一个字节输入流管道与原视频沟通
            InputStream is = new FileInputStream("day09-oop-demo/src/AnotherHardcoreGame 2022-04-09 15-05-20.mp4");

            // 2、创建一个字节输出流管道与目标文件接通
            OutputStream os = new FileOutputStream("day09-oop-demo/src/CopyAnotherHardCoreGame.mp4");

            // 3、定义一个字节数组来转移数据
            byte[] buffer = new byte[1024];
            int len; // 记录每次读取的字节数
            while ((len = is.read(buffer)) != -1){
                os.write(buffer , 0 , len);
            }
            System.out.println("复制完成了！");

            // 4、关闭流
            is.close();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
