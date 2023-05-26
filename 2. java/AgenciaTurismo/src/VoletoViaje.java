public class VoletoViaje extends Reserva {
    public VoletoViaje(double precio) {
        super(precio, "Voleto");
    }

    @Override
    public String toString() {
        return "VoletoViaje{" +
                "precio=" + precio +
                '}';
    }
}
