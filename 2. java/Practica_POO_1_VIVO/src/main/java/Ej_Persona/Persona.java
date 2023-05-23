package Ej_Persona;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getDni() {
        return dni;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public Persona () {

    }
    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }
    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(double estatura, double peso) {

       double imc = (peso / Math.pow(estatura, 2)) ;
        if (imc < 20.0) {
            return -1;
        }
        else if (imc >= 20.0 && imc < 25.0) {
            return 0;
        }
        else {
            return 1;
        }
    }

    public boolean esMayorDeEdad(int edad) {
        return edad > 18;
    }

    @Override
    public String toString() {

        return "El nombre de la persona es: " + this.getNombre() + " la edad es: " +
                this.getEdad() + " el dni es: " + this.getDni() +
                " el peso es: " + this.getPeso() + " la estatura es: "
                + this.getAltura();
    }

}
