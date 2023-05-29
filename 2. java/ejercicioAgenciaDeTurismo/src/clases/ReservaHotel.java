package clases;

public class ReservaHotel {
    private String nombre;
    private String ubicacion;
    private Double total;

    public ReservaHotel(String nombre, String ubicacion,Double total) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.total= total;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ReservaHotel{" +
                "nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", total=" + total +
                '}';
    }
}
