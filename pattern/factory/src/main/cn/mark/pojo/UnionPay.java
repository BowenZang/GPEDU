package main.cn.mark.pojo;

/**
 * @author Mark
 * @since 1.0.0
 * Create on 2020-06-10 20:13:13
 */
public class UnionPay implements IPay {

    @Override
    public String pay() {
        return "UnionPay pay";
    }

    @Override
    public String refund() {
        return "UnionPay refund";
    }

    @Override
    public String withdraw() {
        return "UnionPay withdraw";
    }

}
