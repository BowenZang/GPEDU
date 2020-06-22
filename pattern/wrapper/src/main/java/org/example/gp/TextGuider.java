package org.example.gp;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-22 21:53:54
 */
public class TextGuider extends GuiderWrapper {

    public TextGuider(Guider guider) {
        super(guider);
    }

    @Override
    public String getGuiders() {
        return super.getGuiders() + "题库 ";
    }
}
