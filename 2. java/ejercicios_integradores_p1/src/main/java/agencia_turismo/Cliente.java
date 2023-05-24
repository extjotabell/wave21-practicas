package agencia_turismo;

public class Cliente implements Identificable {

    public Cliente(int id, String nombre, String apellido, int edad, String dni) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getDni() {
        return dni;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String dni;
}
