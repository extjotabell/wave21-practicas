public class Circuito {
    int id_circuito;
    String nombre;
    String descripcion;

    public Circuito(int id_circuito, String nombre, String descripcion) {
        this.id_circuito = id_circuito;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId_circuito() {
        return id_circuito;
    }

    public void setId_circuito(int id_circuito) {
        this.id_circuito = id_circuito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
