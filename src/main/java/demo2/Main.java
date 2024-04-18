package demo2;
import demo2.supermarket.Supermarket;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        // 顾客A购买的水果重量
        BigDecimal appleWeightA = BigDecimal.valueOf(2);
        BigDecimal strawberryWeightA = BigDecimal.valueOf(3);

        // 计算顾客A购买水果的总价，不使用优惠策略
        BigDecimal totalPriceA = Supermarket.calculateTotalPrice(appleWeightA, strawberryWeightA);
        System.out.println("顾客A购买水果总价为：" + totalPriceA + "元");

        // 顾客B购买的水果重量
        BigDecimal appleWeightB = BigDecimal.valueOf(3);
        BigDecimal strawberryWeightB = BigDecimal.valueOf(2);
        BigDecimal mangoWeightB = BigDecimal.valueOf(3);

        // 计算顾客B购买水果的总价
        BigDecimal totalPriceB = Supermarket.calculateTotalPriceWithoutPromotion(appleWeightB, strawberryWeightB, mangoWeightB);
        System.out.println("顾客B购买水果总价为：" + totalPriceB + "元");

        // 顾客C购买的水果重量
        BigDecimal appleWeightC = BigDecimal.valueOf(1);
        BigDecimal strawberryWeightC = BigDecimal.valueOf(4);
        BigDecimal mangoWeightC = BigDecimal.valueOf(2);

        // 计算顾客C购买水果的总价，使用草莓打折优惠策略
        BigDecimal totalPriceC = Supermarket.calculateTotalPriceWithDiscount(appleWeightC, strawberryWeightC,mangoWeightC);
        System.out.println("顾客C购买水果总价为：" + totalPriceC + "元");

        // 顾客D购买的水果重量
        BigDecimal appleWeightD = BigDecimal.valueOf(5);
        BigDecimal strawberryWeightD = BigDecimal.valueOf(6);
        BigDecimal mangoWeightD = BigDecimal.valueOf(7);

        // 计算顾客D购买水果的总价，使用满减优惠策略
        BigDecimal totalPriceD = Supermarket.calculateTotalPriceWithPromotion(appleWeightD, strawberryWeightD, mangoWeightD);
        System.out.println("顾客D购买水果总价为：" + totalPriceD + "元");
    }
}
