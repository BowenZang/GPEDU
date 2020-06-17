package org.example.hungry;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-16 01:11:23
 */
public enum EnumSingleton {
    INSTANCE;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}
