package org.example.cake;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-22 20:35:14
 */
public class SausageWrapper extends BaseCakeWrapper {
    public SausageWrapper(BatterCake batterCake) {
        super(batterCake);
    }

    @Override
    protected void doSth() {
        super.doSth();
    }

    @Override
    public String getMsg() {
        return super.getMsg() + "+ 1 sausage";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 3;
    }
}
