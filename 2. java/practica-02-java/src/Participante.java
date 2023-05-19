public class Participante {
    int id_partipante;
    String dni;
    String nombre;
    String apellido;
    int edad;
    String celular;
    String numero_emergencia;
    String grupo_sanguineo;

    public Participante(int id_partipante, String dni, String nombre, String apellido, int edad, String celular, String numero_emergencia, String grupo_sanguineo) {
        this.id_partipante = id_partipante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numero_emergencia = numero_emergencia;
        this.grupo_sanguineo = grupo_sanguineo;
    }

    public int getId_partipante() {
        return id_partipante;
    }

    public void setId_partipante(int id_partipante) {
        this.id_partipante = id_partipante;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNumero_emergencia() {
        return numero_emergencia;
    }

    public void setNumero_emergencia(String numero_emergencia) {
        this.numero_emergencia = numero_emergencia;
    }

    public String getGrupo_sanguineo() {
        return grupo_sanguineo;
    }

    public void setGrupo_sanguineo(String grupo_sanguineo) {
        this.grupo_sanguineo = grupo_sanguineo;
    }

    public boolean esMenor(){
        return this.edad<18;
    }
}
