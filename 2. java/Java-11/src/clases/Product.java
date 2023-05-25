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

    public double getPrice() {
        return price;
    }

    public int getPurchasedAmount() {
        return purchasedAmount;
    }

    @Override
    public String toString(){
        return new StringBuilder("Codigo: ").append(this.code).append("\n")
                .append("Nombre: ").append(this.name).append("\n")
                .append("Cantidad comprada: ").append(this.purchasedAmount).append("\n")
                .append("Precio unitario: ").append(this.price).append("\n")
                .toString();
    }
}
