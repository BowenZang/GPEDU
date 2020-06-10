package main.cn.mark;

import main.cn.mark.factory.*;

/**
 * @author Mark
 * @since 1.0.0
 * Create on 2020-06-10 20:13:13
 */
public class PayChannelFactoryMain {

    public static void main(String[] args) {

        System.out.println("pay : " + AliPayFactory.INSTANCE.getPayChannel().pay());
        System.out.println("pay : " + WechatPayFactory.INSTANCE.getPayChannel().pay());
        System.out.println("pay : " + CBPayFactory.INSTANCE.getPayChannel().pay());
        System.out.println("pay : " + UnionPayFactory.INSTANCE.getPayChannel().pay());

        System.out.println("refund : " + AliPayFactory.INSTANCE.getPayChannel().pay());
        System.out.println("refund : " + WechatPayFactory.INSTANCE.getPayChannel().pay());
        System.out.println("refund : " + CBPayFactory.INSTANCE.getPayChannel().pay());
        System.out.println("refund : " + UnionPayFactory.INSTANCE.getPayChannel().pay());

        System.out.println("withdraw : " + AliPayFactory.INSTANCE.getPayChannel().pay());
        System.out.println("withdraw : " + WechatPayFactory.INSTANCE.getPayChannel().pay());
        System.out.println("withdraw : " + CBPayFactory.INSTANCE.getPayChannel().pay());
        System.out.println("withdraw : " + UnionPayFactory.INSTANCE.getPayChannel().pay());
    }

}
