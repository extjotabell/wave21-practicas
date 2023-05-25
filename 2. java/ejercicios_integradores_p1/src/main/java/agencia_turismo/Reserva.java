package agencia_turismo;

public abstract class Reserva {
    private double costo;

    public Reserva(double costo) {
        this.costo = costo;
    }

    public double getCosto() {
        return costo;
    }

    public void aplicarDescuento(double descuentoEnPorcentaje) {
        this.costo *= (1 - descuentoEnPorcentaje / 100);
    }

    @Override
    public String toString() {
        return String.valueOf(costo);
    }
}
