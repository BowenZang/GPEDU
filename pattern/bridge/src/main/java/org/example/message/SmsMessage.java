package org.example.message;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-06 20:20:11
 */
public class SmsMessage implements IMessage {
    @Override
    public void send(String message, String touser) {
        System.out.println(String.format("Send sms message : %s to %s", message, touser));

    }
}
