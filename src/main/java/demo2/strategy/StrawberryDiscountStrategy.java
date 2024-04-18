package demo2.strategy;

import demo2.strategy.DiscountStrategy;

import java.math.BigDecimal;

// 草莓打折策略
public class StrawberryDiscountStrategy implements DiscountStrategy {
    private BigDecimal strawberryWeight;
    private BigDecimal strawberryDiscountRate;

    public StrawberryDiscountStrategy(BigDecimal strawberryWeight, BigDecimal strawberryDiscountRate) {
        this.strawberryWeight = strawberryWeight;
        this.strawberryDiscountRate = strawberryDiscountRate;
    }

    @Override
    public BigDecimal calculateDiscount(BigDecimal totalPrice) {
        BigDecimal strawberryDiscount = BigDecimal.ZERO;
        if (strawberryWeight.compareTo(BigDecimal.ZERO) > 0) {
            strawberryDiscount = totalPrice.multiply(strawberryWeight)
                    .multiply(BigDecimal.valueOf(1).subtract(strawberryDiscountRate));
        }
        return strawberryDiscount;
    }
}