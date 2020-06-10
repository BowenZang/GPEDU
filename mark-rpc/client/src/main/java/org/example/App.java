package org.example;

import org.example.api.IHelloService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        IHelloService helloService = RpcProxyClient.clientProxy(IHelloService.class, "127.0.0.1", 8080);
        String result = helloService.sayHello("Mark");
        System.out.println(result);
    }
}
