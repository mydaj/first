package demo2.fruit;

import java.math.BigDecimal;

// 水果类，定义了水果的名称和价格
public class Fruit {
    private String name;
    private BigDecimal pricePerKg;

    public Fruit(String name, BigDecimal pricePerKg) {
        this.name = name;
        this.pricePerKg = pricePerKg;
    }

    public BigDecimal getPricePerKg() {
        return pricePerKg;
    }

    // 获取促销折扣率
    public BigDecimal getDiscountRate() {
        // 返回草莓的折扣率为0.8
        return BigDecimal.valueOf(0.8);
    }
}
