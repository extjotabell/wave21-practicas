package supermercado;

public class Cliente {
    private String nombre;
    private String apellido;
    private String dni;

    public Cliente(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public String obtenerDni(){
        return dni;
    }

    public void mostrar() {
        System.out.printf("Hola, soy %s %s con dni %s%n", nombre, apellido, dni);
    }
}
