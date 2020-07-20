package org.example.state;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-08 18:02:43
 */
public class UnLoginState extends UserState {

    @Override
    public void favorite() {
        this.switch2Login();
        this.context.getState().favorite();
    }

    @Override
    public void comment(String comment) {
        this.switch2Login();
        this.context.getState().comment(comment);
    }

    private void switch2Login() {
        System.out.println("跳转到登陆页面！");
        this.context.setState(AppContext.STATE_LOGIN);
    }
}
