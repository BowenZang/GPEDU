package org.example.loginadapt;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-06 19:29:09
 */
public class PassportForThirdAdapter2 implements IPassportForThird {
    @Override
    public ResultMsg<?> loginForQQ(String openId) {
        return processLogin(openId, LoginForQQAdapter.class);
    }

    @Override
    public ResultMsg<?> loginForWechat(String openId) {
        return processLogin(openId, LoginForWechatAdapter.class);
    }

    @Override
    public ResultMsg<?> loginForToken(String token, String code) {
        return processLogin(token, LoginForTokenAdapter.class);
    }

    @Override
    public ResultMsg<?> loginForTelPhone(String telPhone) {
        return processLogin(telPhone, LoginForTelAdapter.class);
    }

    private ResultMsg<?> processLogin(String id, Class<? extends ILoginAdapt> clazz) {
        try {
            ILoginAdapt loginAdapt = clazz.newInstance();
            return loginAdapt.login(id, loginAdapt);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
