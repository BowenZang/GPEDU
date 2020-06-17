package org.example.hungry;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-16 00:04:05
 */
public class HungryStaticSingleton {

    private static final HungryStaticSingleton INSTANCE;

    static {
        INSTANCE = new HungryStaticSingleton();
    }

    private HungryStaticSingleton() {

    }

    public static HungryStaticSingleton getInstance() {
        return INSTANCE;
    }

}
