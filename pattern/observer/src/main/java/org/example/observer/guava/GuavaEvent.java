package org.example.observer.guava;

import com.google.common.eventbus.Subscribe;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-23 10:16:27
 */
public class GuavaEvent {

    @Subscribe
    public void subscribe(String str) {
        System.out.println("执行subscribe方法，入参数是：" + str);
    }

}
