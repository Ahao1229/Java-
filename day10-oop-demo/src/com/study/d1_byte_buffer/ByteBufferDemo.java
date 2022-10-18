package com.study.d1_byte_buffer;

import java.io.*;

/**
 *  目标：使用字节缓冲流完成后数据的读写操作
 */
public class ByteBufferDemo {
    public static void main(String[] args) {
        try (
                // 这里面只能放置资源对象，用完自动关闭，自动调用资源对象的close方法关闭资源（即使出现异常也会做关闭操作）
                // 1、创建一个字节输入流管道与原视频沟通
                InputStream is = new FileInputStream("day09-oop-demo/src/data04.txt");
                // a. 把原始的字节输入流包装秤高级的缓冲字节输入流
                InputStream bis = new BufferedInputStream(is);

                // 2、创建一个字节输出流管道与目标文件接通
                OutputStream os = new FileOutputStream("day10-oop-demo/src/CopyData01.txt");
                // b. 把字节输出流管道包装成高级的缓冲字节输出流管道
                OutputStream bos = new BufferedOutputStream(os);
                ) {
            // 3、定义一个字节数组来转移数据
            byte[] buffer = new byte[1024];
            int len; // 记录每次读取的字节数
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer , 0 , len);
            }
            System.out.println("复制完成了！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
