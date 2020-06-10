package org.example;

import org.example.api.IHelloService;
import org.example.biz.HelloServiceImpl;
import org.example.proxy.RpcProxyServer;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-05-23 18:16:25
 */
public class App {

    public static void main(String[] args) {
        RpcProxyServer.publisher(new HelloServiceImpl(), 8080);
    }

}
