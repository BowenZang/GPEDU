package org.example.cake;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-22 20:28:43
 */
public abstract class BaseCakeWrapper extends BatterCake {
    // StaticProxy、Delegate
    private final BatterCake batterCake;

    public BaseCakeWrapper(BatterCake batterCake) {
        this.batterCake = batterCake;
    }

    protected void doSth() {};

    @Override
    public String getMsg() {
        return batterCake.getMsg();
    }

    @Override
    public int getPrice() {
        return batterCake.getPrice();
    }
}
