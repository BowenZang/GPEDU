package org.example.chain;

import org.apache.commons.lang.StringUtils;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-07 19:08:41
 */
public class LoginHandler extends Handler {

    @Override
    public void doHandle(Member member) {
        System.out.println("登录成功");
        member.setRoleName("manager");
        chain.doHandle(member);
    }

}
