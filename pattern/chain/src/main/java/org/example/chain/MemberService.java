package org.example.chain;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-07 19:15:12
 */
public class MemberService {

    public void login(String loginName, String loginPwd) {
        Handler.Builder<Member> builder = new Handler.Builder<>();
        builder
                .addHandler(new ValidateHandler())
                .addHandler(new LoginHandler())
                .addHandler(new AuthHandler())
                .build()
                .doHandle(new Member(loginName, loginPwd));


    }

}
