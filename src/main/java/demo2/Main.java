package demo2;

import demo2.strategy.DiscountStrategy;
import demo2.strategy.PromotionDiscountStrategy;
import demo2.strategy.StrawberryDiscountStrategy;
import demo2.supermarket.Supermarket;

import java.math.BigDecimal;



public class Main {
    public static void main(String[] args) {
        // 创建超市对象
        Supermarket supermarket = new Supermarket();

        // 顾客A购买的水果重量
        BigDecimal appleWeightA = BigDecimal.valueOf(2);
        BigDecimal strawberryWeightA = BigDecimal.valueOf(3);

        // 创建顾客A对象，使用草莓打折策略
        DiscountStrategy strawberryDiscountStrategyA = new StrawberryDiscountStrategy(strawberryWeightA, BigDecimal.valueOf(0.8));
        Customer customerA = new Customer(supermarket, appleWeightA, strawberryWeightA, BigDecimal.ZERO, strawberryDiscountStrategyA);
        BigDecimal totalPriceA = customerA.calculateTotalPrice();
        System.out.println("顾客A购买水果总价为：" + totalPriceA + "元");

        // 顾客B购买的水果重量
        BigDecimal appleWeightB = BigDecimal.valueOf(3);
        BigDecimal strawberryWeightB = BigDecimal.valueOf(2);
        BigDecimal mangoWeightB = BigDecimal.valueOf(1);

        // 创建顾客B对象，使用满减策略
        DiscountStrategy promotionDiscountStrategyB = new PromotionDiscountStrategy(BigDecimal.valueOf(100), BigDecimal.TEN);
        Customer customerB = new Customer(supermarket, appleWeightB, strawberryWeightB, mangoWeightB, promotionDiscountStrategyB);
        BigDecimal totalPriceB = customerB.calculateTotalPrice();
        System.out.println("顾客B购买水果总价为：" + totalPriceB + "元");
    }
}
