package clases;

public class Hotel extends Reserva{
    private String nombre;
    public Hotel(double monto, String nombre) {
        super(monto);
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
