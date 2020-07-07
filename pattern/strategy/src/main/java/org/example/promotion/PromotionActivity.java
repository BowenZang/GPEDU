package org.example.promotion;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-07 17:14:28
 */
public class PromotionActivity {

    private static final IPromotionStrategy DEFAULT = new EmptyStrategy();

    private static final Map<String, IPromotionStrategy> STRATEGY_MAP = new ConcurrentHashMap<>();

    static {
        STRATEGY_MAP.put(PromotionEnum.COUPON.name, new CouponStrategy());
        STRATEGY_MAP.put(PromotionEnum.CASHBACK.name, new CashbackStrategy());
        STRATEGY_MAP.put(PromotionEnum.GROUP_BUY.name, new GroupBuyStrategy());
    }

    public enum PromotionEnum {
        COUPON("COUPON"),
        CASHBACK("CASHBACK"),
        GROUP_BUY("GROUP_BUY");

        private final String name;

        PromotionEnum(String name) {
            this.name = name;
        }
    }

    public static IPromotionStrategy getPromotionStrategy(PromotionEnum promotionEnum) {
        if (null == promotionEnum) {
            return DEFAULT;
        }
        return STRATEGY_MAP.get(promotionEnum.name);
    }
}
