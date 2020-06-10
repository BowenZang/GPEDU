package org.example.api.model;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-05-23 18:44:56
 */
public class RpcRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Class<?> clazz;

    /**
     * Method 没有实现序列化，因此这里方法用String
     * @see Method
     */
    private String methodName;

    private Object[] args;

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    @Override
    public String toString() {
        return "RpcRequest{" +
                "clazz=" + clazz +
                ", methodName='" + methodName + '\'' +
                ", args=" + Arrays.toString(args) +
                '}';
    }
}
