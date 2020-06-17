package org.example.hungry;

import java.io.Serializable;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-16 00:01:06
 */
public class SerializableHungrySingleton implements Serializable {

    private static final SerializableHungrySingleton INSTANCE = new SerializableHungrySingleton();

    private SerializableHungrySingleton() {

    }

    public static SerializableHungrySingleton getInstance() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
