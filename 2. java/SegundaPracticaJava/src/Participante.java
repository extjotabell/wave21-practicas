public class Participante {

    int numero;
    int dni;
    String nombre;
    String apellido;
    int edad;
    String celular;
    int numeroEmergencia;
    String grupoSanguineo;

    public Participante(int numero, int dni, String nombre, String apellido, int edad, String celular, int numeroEmergencia, String grupoSanguineo) {
        this.numero = numero;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }
}
