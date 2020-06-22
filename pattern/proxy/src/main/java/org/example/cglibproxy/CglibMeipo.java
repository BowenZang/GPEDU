package org.example.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-18 18:07:16
 */
public class CglibMeipo<T> implements MethodInterceptor {

    public T getInstance(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return (T) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
       before();
       Object obj = methodProxy.invokeSuper(o, objects);
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
