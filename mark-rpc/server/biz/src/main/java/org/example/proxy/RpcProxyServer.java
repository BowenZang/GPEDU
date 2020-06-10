package org.example.proxy;

import org.example.handler.ServerProcessorHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 利用网络socket来接收消费者的服务请求
 *
 * @author 003169
 * @since Create by BowenZang on 2020-05-23 18:26:54
 */
public class RpcProxyServer {

    private final static ExecutorService executorService = Executors.newCachedThreadPool();

    // 发布服务
    public static void publisher(Object service, int port) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // 绑定端口
            serverSocket = new ServerSocket(port);
            // 不断接收请求
            while (true) {
                // NIO阻塞
                socket = serverSocket.accept();
                System.out.println("rpc server get request");
                try {
                    executorService.execute(new ServerProcessorHandler(socket, service));
                    System.out.println("rpc server get request end");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 回收资源
            if (null != socket) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != serverSocket) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
