package main.cn.mark.pojo;

/**
 * @author Mark
 * @since 1.0.0
 * Create on 2020-06-10 20:13:13
 */
public class AliPay implements IPay {
    @Override
    public String pay() {
        return "AliPay pay";
    }

    @Override
    public String refund() {
        return "AliPay refund";
    }

    @Override
    public String withdraw() {
        return "AliPay withdraw";
    }
}
