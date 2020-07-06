package org.example.loginadapt;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-06 15:50:20
 */
public class PassportService {

    /**
     * 注册
     * @param username 用户名
     * @param password 密码
     * @return ResultMsg
     */
    public ResultMsg<Member> regist(String username, String password) {
        return new ResultMsg<>(200, "注册成功", new Member());
    }

    public ResultMsg<?> login(String username, String password) {
        return null;
    }

}
