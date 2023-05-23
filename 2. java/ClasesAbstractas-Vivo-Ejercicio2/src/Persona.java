public class Persona {
    private String Nombre;
    private String Apellido;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public Persona(String nombre, String apellido) {
        Nombre = nombre;
        Apellido = apellido;
    }

    @Override
    public String toString() {
        return "Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'';
    }
}
