package Reservas;

public abstract class Reserva {
    private String nombre;
    private int monto;

    public Reserva(String nombre, int monto) {
        this.nombre = nombre;
        this.monto = monto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMonto() {
        return monto;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "nombre='" + nombre + '\'' +
                ", monto=" + monto +
                '}';
    }
}
