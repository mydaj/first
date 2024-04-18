package demo2;

import demo2.strategy.DiscountStrategy;
import demo2.supermarket.Supermarket;

import java.math.BigDecimal;

// 顾客类，定义了顾客购买水果的行为和计算总价的方法
public class Customer {
    private Supermarket supermarket;
    private BigDecimal appleWeight;
    private BigDecimal strawberryWeight;
    private BigDecimal mangoWeight;
    private DiscountStrategy discountStrategy;

    public Customer(Supermarket supermarket, BigDecimal appleWeight, BigDecimal strawberryWeight, BigDecimal mangoWeight, DiscountStrategy discountStrategy) {
        this.supermarket = supermarket;
        this.appleWeight = appleWeight;
        this.strawberryWeight = strawberryWeight;
        this.mangoWeight = mangoWeight;
        this.discountStrategy = discountStrategy;
    }

    // 计算总价的方法
    public BigDecimal calculateTotalPrice() {
        BigDecimal totalPrice = supermarket.getApple().getPricePerKg().multiply(appleWeight)
                .add(supermarket.getStrawberry().getPricePerKg().multiply(strawberryWeight))
                .add(supermarket.getMango().getPricePerKg().multiply(mangoWeight));

        // Apply discounts
        totalPrice = totalPrice.subtract(discountStrategy.calculateDiscount(totalPrice));

        return totalPrice;
    }
}