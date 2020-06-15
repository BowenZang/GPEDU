package cn.mark.pojo;

/**
 * @author Mark
 * @since 1.0.0
 * Create on 2020-06-10 20:13:13
 */
public class WechatPay implements IPay {

    @Override
    public String pay() {
        return "WechatPay pay";
    }

    @Override
    public String refund() {
        return "WechatPay refund";
    }

    @Override
    public String withdraw() {
        return "WechatPay withdraw";
    }
}
