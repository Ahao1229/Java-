package com.study.d5_resoure;

import java.io.*;

/**
 *   目标：学会使用字节流完成文件的复制（支持一切文件类型的复制）
 */
public class TryCatchFinallyDemo1 {
    public static void main(String[] args){
        // 将管道定义为全局，否则在finally中无法调用关闭
        InputStream is = null;
        OutputStream os = null;
        try {
            // 1、创建一个字节输入流管道与原视频沟通
           is = new FileInputStream("day09-oop-demo/src/data04.txt");

            // 2、创建一个字节输出流管道与目标文件接通
           os = new FileOutputStream("day09-oop-demo/src/CopyData05.txt");

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
        }finally {
            // 无论代码是否正常结束，都会执行这里，除非JVM挂掉
            System.out.println("============finally===========");
            // 4、关闭流
            try {
                // 防止管道使用前出现异常，导致关闭管道抛出空指针异常
                if (os != null){
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                // 防止管道使用前出现异常，导致关闭管道抛出空指针异常
                if (is != null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        System.out.println(test(10,2));
    }

    public static int test (int a , int b){
        try {
            int c = a / b;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }finally {
            // 这里的代码即使上面已经return,也必须执行完这里才可以结束
            // 开发中不建议在这里加return,如果加了，返回的永远是这里的数据了，这样会出问题！
            return 100;
        }
    }

}
