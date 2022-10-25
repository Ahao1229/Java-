package com.study.d2_udp1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收端
 */
public class ServerDemo1 {
    public static void main(String[] args) throws Exception {
        System.out.println("======服务端启动======");
        // 1、创建接受端对象：注册端口（人）
        DatagramSocket socket = new DatagramSocket(8888);

        // 2、创建一个数据包对象接受数据（韭菜盘子）
        byte[] buffer = new byte[1024 * 64];
        DatagramPacket packet =new DatagramPacket(buffer, buffer.length);

        // 3、等待接受数据
        socket.receive(packet);

        // 4、取出数据即可
        // 读多少取多少
        int len = packet.getLength();
        String rs = new String(buffer, 0 ,len);
        System.out.println("收到了" + rs);

        // 获取发送端的ip和端口
        System.out.println("发送端的地址:" + packet.getSocketAddress().toString());
        System.out.println("发送端的端口:" + packet.getPort());

        // 5、关掉管道
        socket.close();

    }
}
