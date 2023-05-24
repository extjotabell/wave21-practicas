package AgenciaDeTurismo;

import java.util.List;

public class Cliente {
    private String nombre;
    private Long dni;

    public Cliente() {
    }

    public Cliente(String nombre, Long dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", dni=" + dni +
                '}';
    }
}
