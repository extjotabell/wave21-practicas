package clases;

public class Comida {
    private String nombre;
    private Double total;

    public Comida(String nombre,Double total) {
        this.nombre = nombre;
        this.total= total;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
