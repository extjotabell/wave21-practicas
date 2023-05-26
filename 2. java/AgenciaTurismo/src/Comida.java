public class Comida extends Reserva {
    public Comida(double precio) {
        super(precio, "Comida");
    }

    @Override
    public String toString() {
        return "Comida{" +
                "precio=" + precio +
                '}';
    }
}
