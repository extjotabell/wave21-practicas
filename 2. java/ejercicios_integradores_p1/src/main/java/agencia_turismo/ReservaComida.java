package agencia_turismo;

public class ReservaComida extends Reserva{
    public ReservaComida(double costo) {
        super(costo);
    }

    @Override
    public String toString() {
        return "Reserva de comida con costo: " + super.toString();
    }
}
