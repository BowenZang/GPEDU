package org.example.mkproxy;

import java.lang.reflect.Method;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-22 16:15:42
 */
public class MKMeiPo<T> implements MKInvocationHandler {

    private T target;

    public T getInstance(T target) {
        this.target = target;
        Class<?> clazz = target.getClass();
        return (T) MKProxy.newProxyInstance(new MKClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(this.target, args);
        after();
        return obj;
    }

    private void before() {
        System.out.println("Beginning find lover");
    }

    private void after() {
        System.out.println("Giving you a lover");
    }
}
