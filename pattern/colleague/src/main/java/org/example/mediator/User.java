package org.example.mediator;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-23 09:07:45
 */
public class User {

    private String name;
    private ChatRoom chatRoom;

    public User(String name, ChatRoom chatRoom) {
        this.name = name;
        this.chatRoom = chatRoom;
    }

    public void sendMessage(String msg) {
        this.chatRoom.showMsg(this, msg);
    }

    public String getName() {
        return name;
    }
}
