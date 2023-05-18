package java_ej2;

public class Participante {
    String nombre;
    String dni;
    String grupo_sanguineo;
    int numero;
    int edad;
    long celular;
    long numero_emergencia;

    public Participante(String nombre, long celular, int edad, int numero, long numero_emergencia, String grupo_sanguineo, String dni) {
        this.nombre = nombre;
        this.celular = celular;
        this.edad = edad;
        this.numero_emergencia = numero_emergencia;
        this.numero = numero;
        this.grupo_sanguineo = grupo_sanguineo;
        this.dni = dni;
    }

    public void mostrar() {
        System.out.println("Nombre " + nombre + " edad " + edad);
    }
}
