package agencia_turismo;


public class ReservaTransporte extends Reserva {
    public ReservaTransporte(double costo) {
        super(costo);
    }

    @Override
    public String toString() {
        return "Reserva de transporte con costo: " + super.toString();
    }
}
