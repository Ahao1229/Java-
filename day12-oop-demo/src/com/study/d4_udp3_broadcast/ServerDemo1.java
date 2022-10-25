package com.study.d4_udp3_broadcast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 接收端
 */
public class ServerDemo1 {
    public static void main(String[] args) throws Exception {
        System.out.println("======服务端启动======");
        // 1、创建接受端对象：注册端口（人）
        DatagramSocket socket = new DatagramSocket(9999);

        while (true) {
            // 2、创建一个数据包对象接受数据（韭菜盘子）
            byte[] buffer = new byte[1024 * 64];
            DatagramPacket packet =new DatagramPacket(buffer, buffer.length);

            // 3、等待接受数据
            socket.receive(packet);

            // 4、取出数据即可
            // 读多少取多少
            int len = packet.getLength();
            String rs = new String(buffer, 0 ,len);
            System.out.println("收到了来自：" + packet.getAddress()+ "对方端口是：" + packet.getPort()+"的消息：" + rs);

        }



    }
}
