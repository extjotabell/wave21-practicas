public class Producto {
    private String name;
    private double price;

    public Producto(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return new StringBuilder()
                .append("Nombre del producto: ").append(this.name).append("\n")
                .append("Precio: ").append(this.price)
                .toString();
    }

    public double calculate(int quantity){
        return this.price * quantity;
    }
}
