public class Hotel extends Reserva {
    public Hotel(double precio) {
        super(precio, "Hotel");
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "precio=" + precio +
                '}';
    }
}
