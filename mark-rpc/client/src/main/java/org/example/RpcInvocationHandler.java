package org.example;

import org.example.api.model.RpcRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-05-23 19:46:44
 */
public class RpcInvocationHandler implements InvocationHandler {

    private final String host;
    private final int post;

    public RpcInvocationHandler(String host, int post) {
        this.host = host;
        this.post = post;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("rpc client send request");
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setClazz(method.getDeclaringClass());
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setArgs(args);
        RpcNetTransport rpcNetTransport = new RpcNetTransport(host, post);
        return rpcNetTransport.send(rpcRequest);
    }
}
