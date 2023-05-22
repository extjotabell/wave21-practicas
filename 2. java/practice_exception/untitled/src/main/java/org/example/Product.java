package org.example;

public class Product {
    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

//    La elección entre "productQuantity" y "productsQuantity" depende del contexto y de
//    cómo se esté utilizando la variable en tu código.
//
//    Si estás utilizando la variable para representar la cantidad total de productos en
//    general, entonces "productsQuantity" podría ser una opción adecuada, ya que indica que se está contando varios productos.
//
//    Sin embargo, si estás utilizando la variable para representar la cantidad de un solo
//    tipo de producto específico, entonces "productQuantity" sería más apropiado, ya que indica que se está contando la cantidad de un producto en particular.

    public double calculate(int productQuantity) {
        return price * productQuantity;
    }
}
