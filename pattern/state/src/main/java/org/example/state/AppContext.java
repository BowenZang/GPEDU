package org.example.state;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-08 18:04:33
 */
public class AppContext extends UserState {

    public static final UserState STATE_LOGIN = new LoginState();
    public static final UserState STATE_UN_LOGIN = new UnLoginState();
    private UserState currentState = STATE_UN_LOGIN;

    {
        STATE_LOGIN.setContext(this);
        STATE_UN_LOGIN.setContext(this);
    }

    public void setState(UserState state) {
        this.currentState = state;
        this.currentState.setContext(this);
    }

    public UserState getState() {
        return this.currentState;
    }

    @Override
    public void favorite() {
        this.currentState.favorite();
    }

    @Override
    public void comment(String comment) {
        this.currentState.comment(comment);
    }

}
