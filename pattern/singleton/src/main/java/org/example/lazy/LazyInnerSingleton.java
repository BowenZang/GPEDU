package org.example.lazy;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-16 00:21:53
 */
public class LazyInnerSingleton {

    private LazyInnerSingleton() {

        if (InnerClass.INSTANCE == null) {
            System.out.println(Thread.currentThread().getName());
        }

        if (null != InnerClass.INSTANCE) {
            throw new RuntimeException("Can not create more than one count");
        }
    }

    public static LazyInnerSingleton getInstance() {
        return InnerClass.INSTANCE;
    }

    private static class InnerClass {
        private static final LazyInnerSingleton INSTANCE = new LazyInnerSingleton();
    }

}
