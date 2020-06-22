package org.example.order;

import java.lang.reflect.*;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-18 15:54:39
 */
public class OrderServiceDynamicProxy<T> implements InvocationHandler {

    private final T target;

    public OrderServiceDynamicProxy(T target) {
        this.target = target;
    }

    public T getTarget() {
        Class<?> clazz = target.getClass();
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(args[0]);
        Object obj = method.invoke(target, args);
        after();
        return obj;
    }

    private void before(Object obj) {
        try {
            System.out.println("Proxy before method");
            DynamicDataSourceEntry.set("DB_" + obj.getClass().getMethod("getId").invoke(obj));
            System.out.println("OrderServiceDynamicProxy DynamicDataSourceEntry : " + DynamicDataSourceEntry.get());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private void after() {
        DynamicDataSourceEntry.restore();
        System.out.println("OrderServiceDynamicProxy DynamicDataSourceEntry : " + DynamicDataSourceEntry.get());

    }
}
