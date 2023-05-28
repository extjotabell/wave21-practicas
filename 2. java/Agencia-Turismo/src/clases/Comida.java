package clases;

public class Comida extends Reserva{
    private String restaurant;
    public Comida(double monto, String restaurant) {
        super(monto);
        this.restaurant = restaurant;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Comida{" +
                "restaurant='" + restaurant + '\'' +
                '}';
    }
}
