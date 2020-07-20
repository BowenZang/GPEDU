package org.example.orderstate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-13 19:17:36
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private StateMachine<OrderStatus, OrderStatusChangeEvent> orderStatusMachine;

    @Autowired
    private StateMachinePersister<OrderStatus, OrderStatusChangeEvent, Order> persister;

    private int id = 1;
    private final Map<Integer, Order> orderMap = new HashMap<>();

    @Override
    public Order create() {
        Order order = new Order();
        order.setStatus(OrderStatus.WAIT_PAYMENT);
        order.setId(id++);
        orderMap.put(order.getId(), order);
        return order;
    }

    @Override
    public Order pay(int id) {
        Order order = orderMap.get(id);
        System.out.println("线程名称：" + Thread.currentThread().getName() + " 尝试支付，订单号：" + id);
        Message<OrderStatusChangeEvent> message = MessageBuilder.withPayload(OrderStatusChangeEvent.PAYED).setHeader("order", order).build();
        if (!sendEvent(message, order)) {
            System.out.println("线程名称：" + Thread.currentThread().getName() + " 支付失败，状态异常，订单号：" + id);
        }
        return orderMap.get(id);
    }

    @Override
    public Order deliver(int id) {
        Order order = orderMap.get(id);
        System.out.println("线程名称：" + Thread.currentThread().getName() + " 尝试支付，订单号：" + id);
        Message<OrderStatusChangeEvent> message = MessageBuilder.withPayload(OrderStatusChangeEvent.DELIVERY).setHeader("order", order).build();
        if (!sendEvent(message, order)) {
            System.out.println("线程名称：" + Thread.currentThread().getName() + " 尝试支付，状态异常，订单号：" + id);
        }
        return orderMap.get(id);
    }

    @Override
    public Order receive(int id) {
        Order order = orderMap.get(id);
        System.out.println("线程名称：" + Thread.currentThread().getName() + " 尝试收获，订单号：" + id);
        Message<OrderStatusChangeEvent> message = MessageBuilder.withPayload(OrderStatusChangeEvent.RECEIVED).setHeader("order", order).build();
        if (!sendEvent(message, order)) {
            System.out.println("线程名称：" + Thread.currentThread().getName() + " 收获失败，状态异常，订单号：" + id);
        }
        return orderMap.get(id);
    }

    @Override
    public Map<Integer, Order> getOrders() {
        return orderMap;
    }

    private synchronized boolean sendEvent(Message<OrderStatusChangeEvent> message, Order order) {
        boolean result = false;
        try {
            orderStatusMachine.start();
            // 尝试恢复状态机状态
            persister.restore(orderStatusMachine, order);
            // 添加延时用于线程安全测试
            Thread.sleep(1000);
            result = orderStatusMachine.sendEvent(message);
            // 持久化状态机状态
            persister.persist(orderStatusMachine, order);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            orderStatusMachine.stop();
        }
        return result;
    }
}
