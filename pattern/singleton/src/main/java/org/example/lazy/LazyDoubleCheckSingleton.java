package org.example.lazy;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-16 00:13:56
 */
public class LazyDoubleCheckSingleton {

    private static LazyDoubleCheckSingleton INSTANCE;

    private LazyDoubleCheckSingleton() {
        if (null != INSTANCE) {
            throw new RuntimeException("Can not create more than one count");
        }
    }

    public static LazyDoubleCheckSingleton getInstance() {
        if (null == INSTANCE) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (null == INSTANCE) {
                    INSTANCE = new LazyDoubleCheckSingleton();
                }
            }
        }
        return INSTANCE;
    }

}
