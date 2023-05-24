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
}
