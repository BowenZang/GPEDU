package main.cn.mark.factory;

import main.cn.mark.pojo.CBPay;
import main.cn.mark.pojo.IPay;

/**
 * @author Mark
 * @since 1.0.0
 * Create on 2020-06-10 20:13:13
 */
public class CBPayFactory implements IPayFactory {

    public final static IPayFactory INSTANCE = new CBPayFactory();

    private CBPayFactory () {
        if (null != INSTANCE) {
            throw new RuntimeException();
        }
    }

    @Override
    public IPay getPayChannel() {
        return new CBPay();
    }
}
