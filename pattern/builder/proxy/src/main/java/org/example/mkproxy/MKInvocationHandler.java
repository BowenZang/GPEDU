package org.example.mkproxy;

import java.lang.reflect.Method;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-18 21:03:17
 */
public interface MKInvocationHandler {

    Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;

}
