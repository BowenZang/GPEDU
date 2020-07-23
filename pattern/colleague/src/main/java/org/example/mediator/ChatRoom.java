package org.example.mediator;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-23 09:09:06
 */
public class ChatRoom {

    public void showMsg(User user, String msg) {
        System.out.println("{" + user.getName() + "} : " + msg);
    }

}
