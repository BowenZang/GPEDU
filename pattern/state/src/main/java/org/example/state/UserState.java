package org.example.state;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-08 18:00:39
 */
public abstract class UserState {

    protected AppContext context;

    public void setContext(AppContext context) {
        this.context = context;
    }

    public abstract void favorite();

    public abstract void comment(String comment);

}
