package org.example.handler;

import org.example.api.model.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-05-23 18:34:15
 */
public class ServerProcessorHandler implements Runnable {

    /**
     * 接收套接字处理内容
     */
    private final Socket socket;

    /**
     * 接收服务类
     */
    private final Object service;

    public ServerProcessorHandler(Socket socket, Object service) {
        this.socket = socket;
        this.service = service;
    }

    @Override
    public void run() {
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            // 读取输入流内容
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            RpcRequest rpcRequest = (RpcRequest) objectInputStream.readObject();

            if (null == rpcRequest) {
                throw new ClassNotFoundException("RpcRequest is null");
            }
            // 执行方法，反射调用本地服务
            Object result = invoke(rpcRequest);

            // 返回结果给调用端
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(result);
            objectOutputStream.flush();
        } catch (IOException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            if (null != objectInputStream) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != objectOutputStream) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Object invoke(RpcRequest rpcRequest) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        if (null == rpcRequest.getClazz()) {
            throw new ClassNotFoundException("RpcRequest.clazz is null");
        }

        if (null == rpcRequest.getMethodName() || "".equals(rpcRequest.getMethodName().trim())) {
            throw new NoSuchMethodException("RpcRequest.method is null");
        }

        // 获取每个参数的类型
        Class<?>[] types = new Class[rpcRequest.getArgs().length];

        for (int i = 0; i < rpcRequest.getArgs().length; i++) {
            types[i] = rpcRequest.getArgs()[i].getClass();
        }

        // 根据参数类型及方法找到对应的方法
        Method method = rpcRequest.getClazz().getMethod(rpcRequest.getMethodName(), types);
        return method.invoke(service, rpcRequest.getArgs());
    }
}
