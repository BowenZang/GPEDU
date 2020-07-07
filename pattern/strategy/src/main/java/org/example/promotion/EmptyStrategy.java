package org.example.promotion;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-07 17:12:51
 */
public class EmptyStrategy implements IPromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("无优惠");
    }
}
