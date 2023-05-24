package agencia_turismo;

public abstract class Reserva {
    public Reserva(double costo) {
        this.costo = costo;
    }

    public double getCosto() {
        return costo;
    }

    private final double costo;
}
