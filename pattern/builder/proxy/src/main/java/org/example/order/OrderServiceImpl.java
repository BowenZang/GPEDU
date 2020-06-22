package org.example.order;

import java.text.SimpleDateFormat;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-18 15:35:05
 */
public class OrderServiceImpl implements IOrderService {

    private final OrderDao orderDao;

    public OrderServiceImpl() {
        this.orderDao = new OrderDao();
    }

    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    private SimpleDateFormat format = new SimpleDateFormat("yyyy");


    @Override
    public int save(Order order) {
        System.out.println("OrderService save order!");
        return orderDao.insert(order);
    }
}
