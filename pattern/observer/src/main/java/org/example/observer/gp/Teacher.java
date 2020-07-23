package org.example.observer.gp;

import java.util.Observable;
import java.util.Observer;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-23 10:09:45
 */
public class Teacher implements Observer {
    private final String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        GPer gPer = (GPer) o;
        Question question = (Question) arg;
        System.out.println("======================");
        System.out.println(name + "老师，您好！\n" + "您收到了一个来自" + gPer.getName()
                + "的提问，希望您解答，问题内容如下：\n" + question.getContent() + "\n"
                + "提问者：" + question.getUsername());
    }
}
