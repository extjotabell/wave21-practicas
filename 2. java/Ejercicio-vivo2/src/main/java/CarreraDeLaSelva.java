public class Participante {
    private int numeroParticipante;
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;

    private String celular;
    private String numeroEmergencia;
    private String grupoSanguineo;


    public Participante(int numeroParticipante, String dni, String nombre, String apellido, int edad, String celular, String numeroEmergencia, String grupoSanguineo) {
        this.numeroParticipante = numeroParticipante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }
}
//clase para categoria

public class Categoria {
    private String nombre;
    private int id;
    private String descripcion;

    public Categoria(String nombre, int id, String descripcion) {
        this.nombre = nombre;
        this.id = id;
        this.descripcion = descripcion;
    }
}

public class Main {
    public static void main(String[] args) {
        Categoria circuitoChico = new Categoria("Circuito Chico", 1, "descripcion 1");
        Categoria circuitoChico = new Categoria("Circuito Medio", 2, "descripcion 2");
        Categoria circuitoChico = new Categoria("Circuito avanzado", 3, "descripcion 3");

        Participante participante = new Participante(0, "12345678k", "Lionel", "Messi", 10, 1212124, 121545, "AB")
    }
}

