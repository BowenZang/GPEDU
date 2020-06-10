package main.cn.mark.factory;

import main.cn.mark.pojo.IPay;

/**
 * @author Mark
 * @since 1.0.0
 * Create on 2020-06-10 20:13:13
 */
public interface IPayFactory {

    IPay getPayChannel();

}
