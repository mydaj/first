package demo;

/*
*
* 水果名称与价格
* */
class Fruit {
    private String name;
    private double pricePerKg;

    public Fruit(String name, double pricePerKg) {
        this.name = name;
        this.pricePerKg = pricePerKg;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }
}

/*
* 超时水果
* */
class Supermarket {
    private Fruit apple;//苹果
    private Fruit strawberry;//草莓
    private Fruit mango;//芒果
    private double strawberryDiscountRate;// 8折
    private double promotionThreshold;//满100减10
    private double promotionDiscount;//10元

    public Supermarket() {
        this.apple = new Fruit("Apple", 8);
        this.strawberry = new Fruit("Strawberry", 13);
        this.mango = new Fruit("Mango", 20);
        this.strawberryDiscountRate = 0.8; // 8折
        this.promotionThreshold = 100; // 满100减10
        this.promotionDiscount = 10;
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

    public double getStrawberryDiscountRate() {
        return strawberryDiscountRate;
    }

    public double getPromotionThreshold() {
        return promotionThreshold;
    }

    public double getPromotionDiscount() {
        return promotionDiscount;
    }
}

/*
* 消费者
* */
class Customer {
    private Supermarket supermarket;//超市
    private double appleWeight;//苹果重量
    private double strawberryWeight;//草莓重量
    private double mangoWeight;//芒果重量

    public Customer(Supermarket supermarket, double appleWeight, double strawberryWeight, double mangoWeight) {
        this.supermarket = supermarket;
        this.appleWeight = appleWeight;
        this.strawberryWeight = strawberryWeight;
        this.mangoWeight = mangoWeight;
    }

    public double calculateTotalPrice() {
        double totalPrice = appleWeight * supermarket.getApple().getPricePerKg() +
                            strawberryWeight * supermarket.getStrawberry().getPricePerKg() +
                            mangoWeight * supermarket.getMango().getPricePerKg();

        // 申请草莓折扣
        totalPrice -= strawberryWeight * (1 - supermarket.getStrawberryDiscountRate()) * supermarket.getStrawberry().getPricePerKg();

        // 申请促销折扣
        if (totalPrice >= supermarket.getPromotionThreshold()) {
            totalPrice -= supermarket.getPromotionDiscount();
        }

        return totalPrice;
    }
}

public class Main {
    public static void main(String[] args) {
        Supermarket supermarket = new Supermarket();
        
        // 顾客 A
        Customer customerA = new Customer(supermarket, 2, 3, 0);
        System.out.println("Customer A total price: " + customerA.calculateTotalPrice());

        // 顾客 B
        Customer customerB = new Customer(supermarket, 2, 3, 1);
        System.out.println("Customer B total price: " + customerB.calculateTotalPrice());

        // 顾客 C
        Customer customerC = new Customer(supermarket, 2, 3, 1);
        System.out.println("Customer C total price: " + customerC.calculateTotalPrice());

    }
}
