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
        return totalPrice;
    }

    // 计算购买苹果、草莓和芒果的总价，使用草莓打折优惠策略
    public static BigDecimal calculateTotalPriceWithDiscount(BigDecimal appleWeight, BigDecimal strawberryWeight, BigDecimal mangoWeight) {
        Supermarket supermarket = new Supermarket();
        BigDecimal totalPrice = supermarket.getApple().getPricePerKg().multiply(appleWeight)
                .add(supermarket.getStrawberry().getPricePerKg().multiply(strawberryWeight))
                .add(supermarket.getMango().getPricePerKg().multiply(mangoWeight));

        BigDecimal strawberryDiscount = supermarket.getStrawberry().getPricePerKg()
                .multiply(strawberryWeight)
                .multiply(BigDecimal.valueOf(1).subtract(supermarket.getStrawberry().getDiscountRate()));

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

}
