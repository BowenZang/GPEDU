package org.example.message;

/**
 * 实现消息发送的统一接口
 *
 * @author 003169
 * @since Create by BowenZang on 2020-07-06 20:19:07
 */
public interface IMessage {

    void send(String message, String touser);

}
