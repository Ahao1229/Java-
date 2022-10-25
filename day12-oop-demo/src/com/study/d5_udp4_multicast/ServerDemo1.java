package com.study.d5_udp4_multicast;

import java.net.*;

/**
 * 接收端
 */
public class ServerDemo1 {
    public static void main(String[] args) throws Exception {
        System.out.println("======服务端启动======");
        // 1、创建接受端对象：注册端口（人）
        MulticastSocket socket = new MulticastSocket(9999);
        // 把当前接收器假如到之前一个组播组中去：绑定对应的组播详细的组播IP
        socket.joinGroup(new InetSocketAddress(InetAddress.getByName("224.0.1.1"),9999),
                NetworkInterface.getByInetAddress(InetAddress.getLocalHost()));
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
