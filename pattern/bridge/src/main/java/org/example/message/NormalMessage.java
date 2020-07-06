package org.example.message;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-06 20:23:32
 */
public class NormalMessage extends AbstractMessage {

    public NormalMessage(IMessage message) {
        super(message);
    }

    @Override
    public void sendMessage(String message, String touser) {
        super.sendMessage(message, touser);
    }
}
