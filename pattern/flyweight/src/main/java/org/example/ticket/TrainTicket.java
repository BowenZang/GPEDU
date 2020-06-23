package org.example.ticket;

import java.util.Random;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-23 14:57:01
 */
public class TrainTicket implements ITicket {
    private final String from;
    private final String to;
    private int price;

    public TrainTicket(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void showInfo(String bunk) {
        this.price = new Random().nextInt(500);
        System.out.println(String.format("%s->%s: %s \r\n 价格: %s 元", from, to, bunk, price));
    }
}
