package clases;

import java.util.Collection;

public class Bill {
    Client client;
    Collection<Product> products;
    double totalPrice;

    public Bill(Client client, Collection<Product> products, double totalPrice) {
        this.client = client;
        this.products = products;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString(){
        return new StringBuilder("Cliente de la factura: ").append(this.client).append("\n")
                .append("Productos: ").append(this.products).append("\n")
                .append("Precio total: ").append(this.totalPrice).append("\n")
                .toString();
    }
}
