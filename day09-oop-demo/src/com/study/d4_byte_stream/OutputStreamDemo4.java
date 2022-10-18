package com.study.d4_byte_stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class OutputStreamDemo4 {
    public static void main(String[] args) throws Exception {
        // 1、创建一个文件字节输出流管道与目标文件接通
       // OutputStream os = new FileOutputStream("day09-oop-demo/src/data04.txt"); // 覆盖管道，先清空之前的数据，写数据进去
        OutputStream os = new FileOutputStream("day09-oop-demo/src/data04.txt" , true); // 追加管道，写之前不会清空写
        // 2、写数据出去
        // a. public void write(int a): 写一个字节
        os.write('a');
        os.write(98);
        os.write("\r\n".getBytes(StandardCharsets.UTF_8)); // 换行
//        os.write('李'); // 中文三个字节，所以会乱码

        // 写数据必须刷新数据，不然可能没有同步到文件中，刷新后流可以接着使用
        os.flush();

        // b. public void write(byte[] buffer):写一个字节数组
        byte[] buffer = {'a', 97, 98, 99};
        os.write(buffer);
        os.write("\r\n".getBytes(StandardCharsets.UTF_8)); // 换行

        byte[] buffer2 = "我是中国人".getBytes(StandardCharsets.UTF_8); // 可以编码传写
        os.write(buffer2);
        os.write("\r\n".getBytes(StandardCharsets.UTF_8)); // 换行

        // c. public void write(byte[] buffer , int pos , int len):写一个字节数组的一部分出去
        byte[] buffer3 = {'a', 97,98,99,100,101,102,103};
        os.write(buffer3, 2 , 2);
        os.write("\r\n".getBytes(StandardCharsets.UTF_8)); // 换行


        // 释放资源，用完关掉节省内存空间（包含刷新）,关闭后流不可以使用
        os.close();
    }
}
