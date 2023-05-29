package clases;

public class Cliente {
    private String nombre;
    private String apellido;
    private String dni;

    private Repositorio repositorio;

    public Cliente(String nombre, String apellido, String dni, Repositorio repositorio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.repositorio = repositorio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Repositorio getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", repositorio=" + repositorio +
                '}';
    }
}
