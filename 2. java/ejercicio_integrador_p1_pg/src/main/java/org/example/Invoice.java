package org.example;
import java.util.List;
public class Invoice {
    private Customer customer;
    private List<Item> items;
    private double total;

    public Invoice(Customer customer, List<Item> items, double total) {
        this.customer = customer;
        this.items = items;
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}