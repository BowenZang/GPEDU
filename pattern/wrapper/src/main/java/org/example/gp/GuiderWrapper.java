package org.example.gp;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-22 21:52:44
 */
public class GuiderWrapper extends Guider {

    private final Guider guider;

    public GuiderWrapper(Guider guider) {
        this.guider = guider;
    }

    @Override
    public String getGuiders() {
        return guider.getGuiders();
    }
}
