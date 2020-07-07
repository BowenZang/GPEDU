package org.example.chain;

import org.apache.commons.lang.StringUtils;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-07 19:08:41
 */
public class ValidateHandler extends Handler {

    @Override
    public void doHandle(Member member) {
        if (StringUtils.isEmpty(member.getLoginName()) || StringUtils.isEmpty(member.getLoginPwd())) {
            System.out.println("用户名或者密码为空");
            return;
        }
        System.out.println("用户名和密码校验成功");
        chain.doHandle(member);
    }

}
