package org.example.lazy;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-16 00:13:56
 */
public class LazyCheckSingleton {

    private static LazyCheckSingleton INSTANCE;

    private LazyCheckSingleton() {

    }

    public synchronized static LazyCheckSingleton getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new LazyCheckSingleton();
        }
        return INSTANCE;
    }

}
