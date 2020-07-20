package org.example.state;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-08 18:02:43
 */
public class LoginState extends UserState {

    @Override
    public void favorite() {
        System.out.println("收藏成功");
    }

    @Override
    public void comment(String comment) {
        System.out.println(comment);
    }
}
