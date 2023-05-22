package org.example;

public class Perishable extends Product {
    private int daysToExpire;

    public Perishable(String name, double price, int daysToExpire) {
        super(name, price);
        this.daysToExpire = daysToExpire;
    }

    public int getDaysToExpiration() {
        return daysToExpire;
    }

    public void setDaysToExpiration(int daysToExpire) {
        this.daysToExpire = daysToExpire;
    }

    @Override
    public String toString() {
        return "Perishable{" +
                "daysToExpire=" + daysToExpire +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public double calculate(int productQuantity) {
        double total = super.calculate(productQuantity);
        if (daysToExpire == 1) {
            total /= 4;
        } else if (daysToExpire == 2) {
            total /= 3;
        } else if (daysToExpire == 3) {
            total /= 2;
        }
        return total;
    }
}
