package clases;

public class Cliente {
    private String dni;
    private String nombre;

    public Cliente(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    @Override
    public String toString(){
        return new StringBuilder("DNI: ").append(this.dni).append(" - ")
                .append("Nombre: ").append(this.nombre)
                .toString();
    }
}
