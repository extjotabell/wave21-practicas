public class Transporte extends Reserva {
    public Transporte(double precio) {
        super(precio, "Transporte");
    }

    @Override
    public String toString() {
        return "Transporte{" +
                "precio=" + precio +
                '}';
    }
}
