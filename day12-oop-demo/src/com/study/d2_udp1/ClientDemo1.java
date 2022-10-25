package com.study.d2_udp1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

/**
 * 发送端  一发  一收
 */
public class ClientDemo1 {
    public static void main(String[] args) throws Exception {
        System.out.println("======客户端启动======");
        // 1、创建一个发送端对象：发送端自带默认的端口号（人）
        DatagramSocket socket = new DatagramSocket(6666);

        // 2、创建一个数据包对象封装数据（韭菜盘子）
        /**
         public DatagramPacket(byte buf[], int offset, int length,
         InetAddress address, int port)
         参数一：封装要发送的数据（韭菜）
         参数二：发送数据的大小
         参数三：服务端的IP地址
         参数四：服务端的端口
         */
        byte[] buffer = "我是一颗快乐的韭菜，你愿意割吗？".getBytes(StandardCharsets.UTF_8);
        DatagramPacket packet =new DatagramPacket(buffer, buffer.length , InetAddress.getLocalHost(), 8888);

        // 3、发送数据出去
        socket.send(packet);

        // 4、管道关掉
        socket.close();

    }
}
