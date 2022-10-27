package com.study.d10_tcp_sms;

import com.study.d8_socket3.ServerReaderThread;
import com.study.d9_socket4.ServerReaderRunnable;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerDemo2 {
    // 定义一个静态的List集合存储当前全部在线的socket管道
    public static List<Socket> allOnlineSocket = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        System.out.println("=========服务端启动=========");
        // 1、注册端口
        ServerSocket serverSocket = new ServerSocket(9999);

        // 循环接收客户端的socket管道请求
        while (true){
            // 2、开始接收客户端的socket管道连接请求
            // 注意：在这里等待客户端的socket管道连接
            Socket socket = serverSocket.accept();
            System.out.println(socket.getRemoteSocketAddress() + "上线了！");
            allOnlineSocket.add(socket);    // 上线完成
            // 创建一个线程来单独处理这个socket管道
            new ServerReaderThread(socket).start();
        }

    }
static class ServerReaderThread extends Thread{
        private Socket socket;

        public ServerReaderThread (Socket socket){
            this.socket = socket;
        }

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(socket.getRemoteSocketAddress() + "发来了" + line);
                // 把这个消息进行端口转发给全部客户端socket管道
                sendMsgToAll(line);
            }
        }catch (Exception e){
            System.out.println(socket.getRemoteSocketAddress() + "下线了");
            ServerDemo2.allOnlineSocket.remove(socket);
        }
    }

    private void sendMsgToAll(String msg) throws Exception {
        for (Socket socket : ServerDemo2.allOnlineSocket) {
            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.println(msg);
            ps.flush();
        }
    }
}
}
