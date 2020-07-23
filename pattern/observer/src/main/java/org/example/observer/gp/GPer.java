package org.example.observer.gp;

import java.util.Observable;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-23 10:05:34
 */
public class GPer extends Observable {

    private final String name = "GPer生态圈";
    private static GPer INSTANCE = null;
    private GPer() {}

    public static GPer getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new GPer();
        }
        return INSTANCE;
    }

    public String getName() {
        return name;
    }

    public void publishQuestion(Question question) {
        System.out.println(question.getUsername() + "在" + this.name + "上提交里一个问题！");
        setChanged();
        notifyObservers(question);
    }
}
