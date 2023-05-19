import java.util.HashMap;

public class Participante {
    private int numero_participante;
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private int celular;
    private int numero_emergencia;
    private String grupo_sanguineo;

    public Participante(int numero_participante, int dni, String nombre, String apellido, int edad, int celular, int numero_emergencia, String grupo_sanguineo) {
        this.numero_participante = numero_participante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numero_emergencia = numero_emergencia;
        this.grupo_sanguineo = grupo_sanguineo;
    }

    public int getEdad() {
        return edad;
    }

    public int getNumero_participante() {
        return numero_participante;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "numero_participante=" + numero_participante +
                ", dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", celular=" + celular +
                ", numero_emergencia=" + numero_emergencia +
                ", grupo_sanguineo='" + grupo_sanguineo + '\'' +
                '}';
    }

    public int calcularInscripcion(HashMap categoria) {
        System.out.println(categoria);
        int inscripcion = 0;
        if (categoria.get("id").equals("circuito1")) {
            if (this.edad < 18) {
                inscripcion = 1300;
            } else {
                inscripcion = 1500;
            }
        } else if (categoria.get("id").equals("circuito2")) {
            if (this.edad < 18) {
                inscripcion = 2000;
            } else {
                inscripcion = 2300;
            }
        } else if (categoria.get("id").equals("circuito3")) {
            if (this.edad > 18) {
                inscripcion = 2800;
            }
        }
        return inscripcion;
    }
}
