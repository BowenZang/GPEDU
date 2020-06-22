package org.example.jdkproxy;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-18 15:15:49
 */
public class LiSi implements IPerson {
    @Override
    public void findLove() {
        System.out.println("LiSi need a girl friend!");
    }

    @Override
    public void findLove(String name) {
        System.out.println("LiSi need a girl friend! Name : " + name);
    }
}
