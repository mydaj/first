package demo2.strategy;

import java.math.BigDecimal;

// 优惠策略接口
public interface DiscountStrategy {
    BigDecimal calculateDiscount(BigDecimal totalPrice);
}