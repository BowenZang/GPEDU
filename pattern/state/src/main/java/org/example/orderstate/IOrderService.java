package org.example.orderstate;

import java.util.Map;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-13 19:15:48
 */
public interface IOrderService {

    /**
     * 创建新订单
     * @return
     */
    Order create();

    /**
     * 发起支付
     * @param id
     * @return
     */
    Order pay(int id);

    /**
     * 订单发货
     * @param id
     * @return
     */
    Order deliver(int id);

    /**
     * 订单收获
     * @param id
     * @return
     */
    Order receive(int id);

    /**
     * 获取所有订单信息
     * @return
     */
    Map<Integer, Order> getOrders();

}
