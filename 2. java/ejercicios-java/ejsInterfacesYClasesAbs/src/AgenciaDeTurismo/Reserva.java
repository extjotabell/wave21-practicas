package AgenciaDeTurismo;

public abstract class Reserva {
    private String nombre;
    private double monto;

    public Reserva() {
    }

    public Reserva(String nombre, double monto) {
        this.nombre = nombre;
        this.monto = monto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "nombre='" + nombre + '\'' +
                ", monto=" + monto +
                '}';
    }
}
