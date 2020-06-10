package main.cn.mark.factory;

import main.cn.mark.pojo.AliPay;
import main.cn.mark.pojo.IPay;

/**
 * @author Mark
 * @since 1.0.0
 * Create on 2020-06-10 20:13:13
 */
public class AliPayFactory implements IPayFactory {

    public final static IPayFactory INSTANCE = new AliPayFactory();

    private AliPayFactory() {
        if (null != INSTANCE) {
            throw new RuntimeException();
        }
    }

    @Override
    public IPay getPayChannel() {
        return new AliPay();
    }
}
