package Clases;

public class Reserva {
    private String id;
    private String tipo; // Hotel, comida, boletos de viaje, transporte)
    private double costo;

    public Reserva(String id, String tipo, double costo) {
        this.id = id;
        this.tipo = tipo;
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id='" + id + '\'' +
                '}';
    }

    public String getTipo() {
        return tipo;
    }

    public double getCosto() {
        return costo;
    }

    public String getId() {
        return id;
    }
}
