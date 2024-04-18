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
}
