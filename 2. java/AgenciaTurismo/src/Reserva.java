public abstract class Reserva {
    protected double precio;
    protected String nombre;

    public Reserva(double precio, String nombre) {
        this.precio = precio;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void descuentoCincoPorciento() {
        this.precio -= this.precio * 0.05;
    }

    public void descuentoDiezPorciento() {
        this.precio -= this.precio * 0.1;
    }

}
