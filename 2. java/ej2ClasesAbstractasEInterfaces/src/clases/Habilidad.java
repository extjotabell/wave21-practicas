package clases;

public class Habilidad {
    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Habilidad{" +
                "descripcion='" + descripcion + '\'' +
                '}';
    }
}
