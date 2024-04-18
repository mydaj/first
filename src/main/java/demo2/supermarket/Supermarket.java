package demo2.supermarket;

import demo2.fruit.Apple;
import demo2.fruit.Mango;
import demo2.fruit.Strawberry;
import demo2.fruit.Fruit;

import java.math.BigDecimal;

// 超市类，定义了超市中的水果种类和价格
public class Supermarket {
    private Fruit apple;
    private Fruit strawberry;
    private Fruit mango;

    public Supermarket() {
        this.apple = new Apple(BigDecimal.valueOf(8));
        this.strawberry = new Strawberry(BigDecimal.valueOf(13));
        this.mango = new Mango(BigDecimal.valueOf(20));
    }

    public Fruit getApple() {
        return apple;
    }

    public Fruit getStrawberry() {
        return strawberry;
    }

    public Fruit getMango() {
        return mango;
    }

    // 计算购买苹果和草莓的总价
    public static BigDecimal calculateTotalPrice(BigDecimal appleWeight, BigDecimal strawberryWeight) {
        Supermarket supermarket = new Supermarket();
        BigDecimal totalPrice = supermarket.getApple().getPricePerKg().multiply(appleWeight)
                .add(supermarket.getStrawberry().getPricePerKg().multiply(strawberryWeight));
        return totalPrice;
    }

    // 计算购买苹果、草莓和芒果的总价，参加满减优惠活动
    public static BigDecimal calculateTotalPriceWithPromotion(BigDecimal appleWeight, BigDecimal strawberryWeight, BigDecimal mangoWeight) {
        Supermarket supermarket = new Supermarket();
        BigDecimal totalPrice = supermarket.getApple().getPricePerKg().multiply(appleWeight)
                .add(supermarket.getStrawberry().getPricePerKg().multiply(strawberryWeight))
                .add(supermarket.getMango().getPricePerKg().multiply(mangoWeight));

        if (totalPrice.compareTo(BigDecimal.valueOf(100)) >= 0) {
            totalPrice = totalPrice.subtract(BigDecimal.TEN);
        }
        /*  // 满减优惠：每满100元减10元
        BigDecimal promotionDiscount = BigDecimal.ZERO;
        // 计算满减优惠金额
        promotionDiscount = calculatePromotionDiscount(totalPrice);

        // 总价减去满减优惠
        totalPrice = totalPrice.subtract(promotionDiscount);*/

        return totalPrice;
    }

    // 计算购买苹果、草莓和芒果的总价，使用草莓打折优惠策略
    // 计算购买苹果、草莓和芒果的总价，使用折扣优惠策略
    public static BigDecimal calculateTotalPriceWithDiscount(BigDecimal appleWeight, BigDecimal strawberryWeight, BigDecimal mangoWeight) {
        Supermarket supermarket = new Supermarket();
        BigDecimal totalPrice = supermarket.getApple().getPricePerKg().multiply(appleWeight)
                .add(supermarket.getStrawberry().getPricePerKg().multiply(strawberryWeight))
                .add(supermarket.getMango().getPricePerKg().multiply(mangoWeight));

        // 计算草莓的折扣金额
        BigDecimal strawberryDiscount = calculateDiscount(supermarket.getStrawberry().getPricePerKg(), strawberryWeight, supermarket.getStrawberry().getDiscountRate());

        // 总价减去草莓的折扣金额
        totalPrice = totalPrice.subtract(strawberryDiscount);

        return totalPrice;
    }

    // 计算购买苹果、草莓和芒果的总价，不使用满减策略
    public static BigDecimal calculateTotalPriceWithoutPromotion(BigDecimal appleWeight, BigDecimal strawberryWeight, BigDecimal mangoWeight) {
        Supermarket supermarket = new Supermarket();
        BigDecimal totalPrice = supermarket.getApple().getPricePerKg().multiply(appleWeight)
                .add(supermarket.getStrawberry().getPricePerKg().multiply(strawberryWeight))
                .add(supermarket.getMango().getPricePerKg().multiply(mangoWeight));
        return totalPrice;
    }

    // 计算草莓折扣金额的方法
    private static BigDecimal calculateDiscount(BigDecimal pricePerKg, BigDecimal weight, BigDecimal discountRate) {
        return pricePerKg.multiply(weight).multiply(BigDecimal.ONE.subtract(discountRate));
    }

    // 计算满减优惠金额的方法  每满100减10元
    private static BigDecimal calculatePromotionDiscount(BigDecimal totalPrice) {
        BigDecimal discountPer100 = BigDecimal.valueOf(10);
        return totalPrice.divideToIntegralValue(BigDecimal.valueOf(100)).multiply(discountPer100);
    }

}
