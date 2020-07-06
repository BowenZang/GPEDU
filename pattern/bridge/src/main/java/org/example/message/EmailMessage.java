package org.example.message;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-06 20:19:37
 */
public class EmailMessage implements IMessage {
    @Override
    public void send(String message, String touser) {
        System.out.println(String.format("Send email message : %s to %s", message, touser));
    }
}
