package org.example.order;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-18 15:42:17
 */
public class OrderServiceStaticProxy implements IOrderService {

    private final IOrderService orderService;

    public OrderServiceStaticProxy(IOrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public int save(Order order) {
        before();
        DynamicDataSourceEntry.set("DB_" + order.getId());
        System.out.println("StaticProxy datasource : " + DynamicDataSourceEntry.get());
        int result = orderService.save(order);
        after();
        return result;
    }

    private void before() {
        System.out.println("Proxy before method.");
    }

    private void after() {
        DynamicDataSourceEntry.restore();
        System.out.println("DynamicDataSourceEntry.restore : " + DynamicDataSourceEntry.get());
        System.out.println("Proxy after method.");
    }
}
