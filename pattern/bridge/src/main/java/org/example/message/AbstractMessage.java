package org.example.message;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-06 20:22:04
 */
public abstract class AbstractMessage {

    protected IMessage message;

    public AbstractMessage(IMessage message) {
        this.message = message;
    }

    public void sendMessage(String message, String touser) {
        this.message.send(message, touser);
    }
}
