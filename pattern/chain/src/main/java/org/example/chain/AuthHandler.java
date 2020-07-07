package org.example.chain;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-07 19:08:41
 */
public class AuthHandler extends Handler {

    @Override
    public void doHandle(Member member) {
        if (!"manager".equals(member.getRoleName())) {
            System.out.println("您不是管理员，没有操作权限");
            return;
        }
        System.out.println("您是管理员");
        chain.doHandle(member);
    }

}
