package org.example.hungry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-16 01:45:39
 */
public class ContainerSingleton {

    private ContainerSingleton() {

    }

    private static final Map<String, Object> ioc = new ConcurrentHashMap<>();

//    public static Object getBean(String className) {
//        if (!ioc.containsKey(className)) {
//            synchronized (ioc) {
//                if (!ioc.containsKey(className)) {
//                    try {
//                        ioc.putIfAbsent(className, Class.forName(className).newInstance());
//                    } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//        return ioc.get(className);
//    }

    public static Object getBean(String className) {
        try {
            ioc.putIfAbsent(className, Class.forName(className).newInstance());
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ioc.get(className);
    }


}
