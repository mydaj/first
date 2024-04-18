package demo2.strategy;

import java.math.BigDecimal;

// 满减策略
public class PromotionDiscountStrategy implements DiscountStrategy {
    private BigDecimal promotionThreshold;
    private BigDecimal promotionDiscount;

    public PromotionDiscountStrategy(BigDecimal promotionThreshold, BigDecimal promotionDiscount) {
        this.promotionThreshold = promotionThreshold;
        this.promotionDiscount = promotionDiscount;
    }

    @Override
    public BigDecimal calculateDiscount(BigDecimal totalPrice) {
        return (totalPrice.compareTo(promotionThreshold) >= 0)
                ? promotionDiscount
                : BigDecimal.ZERO;
    }
}