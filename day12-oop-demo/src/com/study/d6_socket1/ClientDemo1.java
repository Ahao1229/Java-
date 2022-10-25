package com.study.d6_socket1;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 *  目标：完成Socket网络编程入门案例的客户端开发，实现1发1收
 */
public class ClientDemo1 {
    public static void main(String[] args) {
        System.out.println("=======客户端启动=======");
        try {
            // 1、创建Socket通信管道清秀有服务端的连接
            // public Socket(String host, int port)
            // 参数一：服务器的IP地址
            // 参数二：服务器的端口
            Socket socket = new Socket("192.168.43.173",7777);

            // 2、从Socket通信管道中得到一个字节输出流，负责发送数据
            OutputStream os = socket.getOutputStream();

            // 3、把低级的字节流包装成打印流
            PrintStream ps = new PrintStream(os);

            // 4、发送消息
            ps.println("我是TCP的客户端，我已经与你对接，并发出邀请：约吗？");
            ps.flush();

            // 关闭资源
//            socket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
