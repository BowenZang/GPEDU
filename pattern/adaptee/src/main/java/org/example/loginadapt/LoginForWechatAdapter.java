package org.example.loginadapt;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-06 19:17:34
 */
public class LoginForWechatAdapter extends AbstractAdapter {

    @Override
    public <T extends ILoginAdapt> ResultMsg<?> login(String id, T adapter) {
        return super.loginRegist(id, adapter);
    }
}
