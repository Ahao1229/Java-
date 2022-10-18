package com.study.d5_resoure;

import java.io.*;

/**
 * JDK9 资源释放优化  做了解
 */
public class TryCatchResourceDemo3 {
    public static void main(String[] args) throws Exception {
        // 1、创建一个字节输入流管道与原视频沟通
        InputStream is = new FileInputStream("day09-oop-demo/src/data04.txt");
        // 2、创建一个字节输出流管道与目标文件接通
        OutputStream os = new FileOutputStream("day09-oop-demo/src/CopyData05.txt");
        try (is ; os) {

            // 3、定义一个字节数组来转移数据
            byte[] buffer = new byte[1024];
            int len; // 记录每次读取的字节数
            while ((len = is.read(buffer)) != -1){
                os.write(buffer , 0 , len);
            }
//            System.out.println(10 / 0);
            System.out.println("复制完成了！");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
