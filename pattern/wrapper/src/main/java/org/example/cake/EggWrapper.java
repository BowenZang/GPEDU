package org.example.cake;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-22 20:32:41
 */
public class EggWrapper extends BaseCakeWrapper {

    public EggWrapper(BatterCake batterCake) {
        super(batterCake);
    }

    @Override
    protected void doSth() {
        super.doSth();
    }

    @Override
    public String getMsg() {
        return super.getMsg() + "+ 1 egg";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 1;
    }
}
