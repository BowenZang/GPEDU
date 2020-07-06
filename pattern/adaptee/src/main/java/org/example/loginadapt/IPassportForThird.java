package org.example.loginadapt;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-06 15:57:39
 */
public interface IPassportForThird {

    ResultMsg<?> loginForQQ(String openId);

    ResultMsg<?> loginForWechat(String openId);

    ResultMsg<?> loginForToken(String token, String code);

    ResultMsg<?> loginForTelPhone(String telPhone);
}
