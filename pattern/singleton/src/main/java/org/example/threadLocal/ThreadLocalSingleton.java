package org.example.threadLocal;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-16 01:50:11
 */
public class ThreadLocalSingleton {

    private static final ThreadLocal<ThreadLocalSingleton> THREAD_LOCAL_INSTANCE = ThreadLocal.withInitial(ThreadLocalSingleton::new);

    private ThreadLocalSingleton() {}

    public static ThreadLocalSingleton getInstance() {
        return THREAD_LOCAL_INSTANCE.get();
    }

}
