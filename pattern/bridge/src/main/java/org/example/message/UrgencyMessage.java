package org.example.message;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-06 20:24:31
 */
public class UrgencyMessage extends AbstractMessage {
    public UrgencyMessage(IMessage message) {
        super(message);
    }

    @Override
    public void sendMessage(String message, String touser) {
        message += "be quick!";
        super.sendMessage(message, touser);
    }

    /**
     * 监控某个消息的当前状态
     * @param messageId messageId
     * @return Object
     */
    public Object watch(String messageId) {
        return null;
    }
}
