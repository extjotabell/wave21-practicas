package clases;

public class Transporte extends Reserva{
    public Transporte(double monto) {
        super(monto);
    }

    @Override
    public String toString() {
        return "Transporte{" +
                "$'" + getMonto() + '\'' +
                '}';
    }
}
