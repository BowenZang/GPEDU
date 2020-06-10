package org.example;

import java.lang.reflect.Proxy;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-05-23 19:44:17
 */
public class RpcProxyClient {

    public static <T> T clientProxy(Class<T> interfaceClazz, String host, int port) {
        return (T) Proxy.newProxyInstance(interfaceClazz.getClassLoader(), new Class[]{interfaceClazz}, new RpcInvocationHandler(host, port));
    }

}
