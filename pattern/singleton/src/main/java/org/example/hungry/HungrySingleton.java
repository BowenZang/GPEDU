package org.example.hungry;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-16 00:01:06
 */
public class HungrySingleton {

    private static final HungrySingleton INSTANCE = new HungrySingleton();

    private HungrySingleton() {

    }

    public static HungrySingleton getInstance() {
        return INSTANCE;
    }

}
