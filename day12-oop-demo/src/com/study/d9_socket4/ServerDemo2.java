package com.study.d9_socket4;

import com.study.d8_socket3.ServerReaderThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 *  目标：目标：使用线程池优化：实现通信。
 */
public class ServerDemo2 {

    // 使用静态变量记住一个线程池对象
    private static ExecutorService pool = new ThreadPoolExecutor(3,
            5, 6, TimeUnit.SECONDS,new ArrayBlockingQueue<>(2),
            Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        try {
            System.out.println("=====服务端启动=====");
            // 1、注册端口
            ServerSocket serverSocket = new ServerSocket(7777);
            // a.定义一个死循环由主线程负责不断的接收客户端的Socket管道连接
            while (true) {
                // 2、每接收到一个客户端的Socket管道，交给一个独立的子线程负责读取消息
                Socket socket = serverSocket.accept();
                System.out.println(socket.getRemoteSocketAddress() + "上线了！");
                // 任务对象负责读取消息
                Runnable target = new ServerReaderRunnable(socket);
                pool.execute(target);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
