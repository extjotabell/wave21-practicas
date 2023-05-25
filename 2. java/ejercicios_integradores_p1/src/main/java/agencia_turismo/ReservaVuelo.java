package agencia_turismo;

public class ReservaVuelo extends Reserva {
    public ReservaVuelo(double costo) {
        super(costo);
    }

    @Override
    public String toString() {
        return "Reserva de vuelo con costo: " + super.toString();
    }
}
