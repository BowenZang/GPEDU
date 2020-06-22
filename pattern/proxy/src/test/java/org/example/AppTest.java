package org.example;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import net.sf.cglib.core.DebuggingClassWriter;
import org.example.cglibproxy.CglibMeipo;
import org.example.jdkproxy.IPerson;
import org.example.jdkproxy.LiSi;
import org.example.jdkproxy.MeiPoHandler;
import org.example.jdkproxy.ZhangSan;
import org.example.mkproxy.MKMeiPo;
import org.example.order.*;
import org.example.staticproxy.RealSubject;
import org.example.staticproxy.SubjectProxy;
import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Unit test for simple App.
 */
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
    public void staticProxyTest() {
        SubjectProxy proxy = new SubjectProxy(new RealSubject());
        proxy.doSth();
    }

    @Test
    public void jdkProxyTest() {
        MeiPoHandler meiPoHandler = new MeiPoHandler();
        meiPoHandler.getInstance(new ZhangSan()).findLove();
        meiPoHandler.getInstance(new LiSi()).findLove();

        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{IPerson.class});
        FileOutputStream os = null;
        try {
            os = new FileOutputStream("$Proxy0.class");
            os.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert os != null;
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void orderStaticProxyTest() {
        OrderServiceStaticProxy proxy = new OrderServiceStaticProxy(new OrderServiceImpl(new OrderDao()));
        Order order = new Order();
        order.setId(111111111L);
        order.setOrderInfo("Order one");
        proxy.save(order);
    }

    @Test
    public void orderDynamicProxyTest() {
        IOrderService orderService = new OrderServiceDynamicProxy<>(new OrderServiceImpl(new OrderDao())).getTarget();
        Order order = new Order();
        order.setId(111111111L);
        order.setOrderInfo("Order one");
        orderService.save(order);
    }

    @Test
    public void cglibProxyTest() {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/bowenzang/IdeaProjects/GPEDU/pattern/proxy");
        IOrderService orderService = new CglibMeipo<IOrderService>().getInstance(OrderServiceImpl.class);
        Order order = new Order();
        order.setId(111111111L);
        order.setOrderInfo("Order one");
        orderService.save(order);
    }

    @Test
    public void mkProxyTest() {
        IPerson person = new MKMeiPo<IPerson>().getInstance(new LiSi());
        person.findLove();
        person.findLove("lili");
        System.out.println(person.getClass());
    }
}
