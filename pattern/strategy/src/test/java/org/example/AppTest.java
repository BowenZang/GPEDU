package org.example;

import static org.junit.Assert.assertTrue;

import org.example.promotion.PromotionActivity;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void promotionTest() {
        PromotionActivity.getPromotionStrategy(PromotionActivity.PromotionEnum.COUPON).doPromotion();
        PromotionActivity.getPromotionStrategy(PromotionActivity.PromotionEnum.GROUP_BUY).doPromotion();
        PromotionActivity.getPromotionStrategy(PromotionActivity.PromotionEnum.CASHBACK).doPromotion();
        PromotionActivity.getPromotionStrategy(null).doPromotion();
    }
}
