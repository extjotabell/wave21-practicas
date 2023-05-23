public class Participante {
    public int id_participante;
    public int dni;
    public String nombre;
    public  String apellido;
    public int edad;
    public String celular;
    public String numero_emergencia;
    public String grupo_sanguineo;

    public Participante(int id_participante, int dni, String nombre, String apellido, int edad, String celular, String numero_emergencia, String grupo_sanguineo) {
        this.id_participante = id_participante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numero_emergencia = numero_emergencia;
        this.grupo_sanguineo = grupo_sanguineo;
    }

    public boolean esMenor (Participante participante) {
        return participante.edad > 18;
    }
}
