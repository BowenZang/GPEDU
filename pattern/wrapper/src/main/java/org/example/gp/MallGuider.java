package org.example.gp;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-22 21:53:54
 */
public class MallGuider extends GuiderWrapper {

    public MallGuider(Guider guider) {
        super(guider);
    }

    @Override
    public String getGuiders() {
        return super.getGuiders() + "商城 ";
    }
}
