package org.example.gp;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-22 21:53:54
 */
public class HomeworkGuider extends GuiderWrapper {

    public HomeworkGuider(Guider guider) {
        super(guider);
    }

    @Override
    public String getGuiders() {
        return super.getGuiders() + "作业 ";
    }
}
