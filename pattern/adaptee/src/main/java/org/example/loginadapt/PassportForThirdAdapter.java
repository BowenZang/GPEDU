package org.example.loginadapt;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-06 15:59:10
 */
public class PassportForThirdAdapter extends PassportService implements IPassportForThird {

    @Override
    public ResultMsg<?> loginForQQ(String openId) {
        return loginForRegist(openId, null);
    }

    @Override
    public ResultMsg<?> loginForWechat(String openId) {
        return loginForRegist(openId, null);
    }

    @Override
    public ResultMsg<?> loginForToken(String token, String code) {
        return loginForRegist(token, null);
    }

    @Override
    public ResultMsg<?> loginForTelPhone(String telPhone) {
        return loginForRegist(telPhone, null);
    }

    private ResultMsg<?> loginForRegist(String username, String password) {
        if (null == password) {
            password = "THIRD_EMPTY";
        }

        super.regist(username, password);

        return super.login(username, password);
    }
}
