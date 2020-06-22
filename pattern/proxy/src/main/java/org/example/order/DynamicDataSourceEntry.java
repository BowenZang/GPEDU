package org.example.order;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-18 15:37:21
 */
public class DynamicDataSourceEntry {

    public static final String DEFAULT_DATASOURCE = "DB_";

    private static final ThreadLocal<String> DATASOURCE_THREAD_LOCAL = new ThreadLocal<>();

    private DynamicDataSourceEntry() {

    }

    public static String get() {
        return DATASOURCE_THREAD_LOCAL.get();
    }

    public static void set(String datasource) {
        DATASOURCE_THREAD_LOCAL.set(datasource);
    }

    public static void restore() {
        DATASOURCE_THREAD_LOCAL.set(DEFAULT_DATASOURCE);
    }

    public static void clean() {
        DATASOURCE_THREAD_LOCAL.remove();
    }

}
