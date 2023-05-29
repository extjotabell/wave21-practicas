import java.util.List;

public class Cliente {
    String nombre;
    String apellido;
    String dni;

    public Cliente(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
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

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }

    public static boolean existeCliente(List<Cliente> clientes, Cliente clienteBuscado){
        Boolean seEncontro = false;
        for (Cliente client:clientes) {
            if(client.equals(clienteBuscado)){
                seEncontro = true;
            }
        }
        return seEncontro;
    }

    public Cliente findBy(){

        return null;
    }
}
