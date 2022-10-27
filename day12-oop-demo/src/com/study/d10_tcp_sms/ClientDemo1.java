package com.study.d10_tcp_sms;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 *  1、客户端发送消息
 *  2、客户端随时可能需要收到消息
 */
public class ClientDemo1 {
    public static void main(String[] args) throws Exception {
        System.out.println("========客户端启动========");
        // 1、连接与服务端的Socket管道连接
        Socket socket = new Socket("192.168.43.173" , 9999);

        // 创建一个独立的线程，专门负责这个客户端的读消息（服务端随时可能转发消息过来）
        new ClientReaderThread(socket).start();

        // 2、从Socket管道中得到一个字节输出流管道
        OutputStream os = socket.getOutputStream();
        // 3、把低级的输出流包装成高级的打印流
        PrintStream ps = new PrintStream(os);
        // 4、发送数据
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("请说：");
            String msg = sc.nextLine();
            ps.println(msg);
            ps.flush();
        }
    }
    static class ClientReaderThread extends Thread{
        private Socket socket;

        public ClientReaderThread (Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // 3、字节输入流
                InputStream is = socket.getInputStream();
                // 4、把低级的字节输入流包装成高级的缓冲字节输入流
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                // 5、按照行读读取
                String line;
                while ((line = br.readLine()) != null){
                    System.out.println("收到消息:" +line);
                }
            }catch (Exception e){
                System.out.println("你已被t出群聊");
            }
        }
    }


}
