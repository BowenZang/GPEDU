package cn.mark.factory;

import cn.mark.pojo.IPay;
import cn.mark.pojo.UnionPay;

/**
 * @author Mark
 * @since 1.0.0
 * Create on 2020-06-10 20:13:13
 */
public class UnionPayFactory implements IPayFactory {

    public final static IPayFactory INSTANCE = new UnionPayFactory();

    private UnionPayFactory () {
        if (null != INSTANCE) {
            throw new RuntimeException();
        }
    }

    @Override
    public IPay getPayChannel() {
        return new UnionPay();
    }
}
