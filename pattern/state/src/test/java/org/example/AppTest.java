package org.example;

import static org.junit.Assert.assertTrue;

import org.example.orderstate.IOrderService;
import org.example.state.AppContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = State.class)
public class AppTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void stateTest() {
        AppContext context = new AppContext();
        context.favorite();
        context.comment("评论");
    }

    @Autowired
    private IOrderService orderService;

    @Test
    public void orderStateTest() {
        Thread.currentThread().setName("主线程");
        orderService.create();
        orderService.create();

        orderService.pay(1);

        new Thread(() -> {
            orderService.deliver(1);
            orderService.receive(1);
        }).start();

        orderService.pay(2);
        orderService.deliver(2);
        orderService.receive(2);

        System.out.println("全部订单状态：" + orderService.getOrders());
    }
}
