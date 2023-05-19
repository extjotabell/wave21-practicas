package main;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private float peso;
    private float altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni, float peso, float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public int calcularIMC(){
        float imc = this.peso/(this.altura*this.altura);
        if (imc<20) {
            return -1;
        } else if (imc>= 20 && imc<=25) {
            return 0;
        } else{
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        return this.edad>18;
    }

    public String toString(){
        return "Nombre: " + this.nombre +", Edad " + this.edad + ", Dni: " + this.dni + ", Peso: " + this.peso + ", altura: " + this.altura;
    }
}
