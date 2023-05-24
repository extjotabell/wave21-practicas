package clases;

public class Product {
    String code;
    String name;
    int purchasedAmount;
    double price;

    public Product(String code, String name, int purchasedAmount, double price) {
        this.code = code;
        this.name = name;
        this.purchasedAmount = purchasedAmount;
        this.price = price;
    }
}
