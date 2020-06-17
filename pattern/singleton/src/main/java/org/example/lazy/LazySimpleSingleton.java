package org.example.lazy;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-16 00:06:50
 */
public class LazySimpleSingleton {

    private static LazySimpleSingleton INSTANCE;

    private LazySimpleSingleton() {

    }

    public static LazySimpleSingleton getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new LazySimpleSingleton();
        }
        return INSTANCE;
    }

}
