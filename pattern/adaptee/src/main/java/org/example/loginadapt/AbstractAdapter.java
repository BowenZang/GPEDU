package org.example.loginadapt;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-06 19:18:10
 */
public abstract class AbstractAdapter extends PassportService implements ILoginAdapt {

    private boolean close;

    private boolean support(ILoginAdapt adapt) {
        return adapt.isClose();
    }

    public boolean isClose() {
        return this.close;
    }

    protected ResultMsg<?> loginRegist(String id, ILoginAdapt adapt) {
        if (isClose()) {
             return null;
        }
        return super.login(id, null);
    }

}
