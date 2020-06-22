package org.example.gp;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-22 21:53:54
 */
public class AskGuider extends GuiderWrapper {

    public AskGuider(Guider guider) {
        super(guider);
    }

    @Override
    public String getGuiders() {
        return super.getGuiders() + "问答 ";
    }
}
