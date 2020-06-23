package org.example;

import static org.junit.Assert.assertTrue;

import org.example.ticket.ITicket;
import org.example.ticket.TicketFactory;
import org.junit.Test;

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
    public void ticketTest() {
        // 内部状态
        ITicket ticket1 = TicketFactory.queryTicket("深圳", "西宁");
        ITicket ticket2 = TicketFactory.queryTicket("深圳", "西宁");
        ITicket ticket3 = TicketFactory.queryTicket("深圳", "西宁");
        // 外部状态
        ticket1.showInfo("硬座");
        ticket2.showInfo("卧铺");
        ticket3.showInfo("软卧");

        System.out.println("ticket1 : " + ticket1);
        System.out.println("ticket2 : " + ticket2);
        System.out.println("ticket3 : " + ticket3);
    }

    @Test
    public void StringTest() {
        String s1 = "hello";// 字面量，存在常量池
        String s2 = "hello";// 同s1
        String s3 = "he" + "llo";// 两个字面量想加后的到字面量存在常量池
        String s4 = "hel" + new String("lo");// 第二个是对象，对象存在堆，对象内的值lo存在常量池
        String s5 = new String("hello");// 同上
        String s6 = s5.intern();// 对象转为字面量，存在常量池
        String s7 = "he";
        String s8 = "llo";
        String s9 = s7 + s8; // 实际是两个对象相加，存在堆中
        System.out.println(s1 == s2); // true 字面量相比
        System.out.println(s1 == s3); // true 同上
        System.out.println(s1 == s4); // false
        System.out.println(s1 == s5); // false
        System.out.println(s1 == s6); // true
        System.out.println(s1 == s9); // false
        System.out.println(s4 == s5); // false
    }

    @Test
    public void IntegerTest () {
        Integer a = Integer.valueOf(100);
        Integer b = 100;

        System.out.println(a == b);

        Integer c = Integer.valueOf(1000);
        Integer d = 1000;
        System.out.println(c == d);

        // 看源码可以通过指定JVM参数java.lang.Integer.IntegerCache.high来扩大Integer 常量池的范围，默认-128~127
        // 指定ava.lang.Integer.IntegerCache.high = 1024
        Integer e = Integer.valueOf(1025);
        Integer f = 1025;
        System.out.println(e == f);
    }

    @Test
    public void LongTest () {
        Long a = Long.valueOf(100);
        Long b = 100L;

        System.out.println(a == b);

        Long c = Long.valueOf(128);
        Long d = 128L;
        System.out.println(c == d);
        // Long常量池的范围，默认-128~127，且不能指定大小
    }
}
