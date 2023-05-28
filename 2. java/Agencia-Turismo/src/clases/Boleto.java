package clases;

public class Boleto extends Reserva{
    private String destino;

    public Boleto(double monto, String destino) {
        super(monto);
        this.destino = destino;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public String toString() {
        return "Boleto{" +
                "destino='" + destino + '\'' +
                '}';
    }
}
