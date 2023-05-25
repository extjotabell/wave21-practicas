package model;

public class Cliente {
    private Long dni;
    private String nombre;
    private String apelido;

    public Cliente() {
    }

    public Cliente(Long dni, String nombre, String apelido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apelido = apelido;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    @Override
    public String toString() {
        return "model.Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apelido='" + apelido + '\'' +
                '}';
    }
}
