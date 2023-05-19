package org.example;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    //Estructura básica de la clase: Atributos, Constructor, Métodos

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
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
        double imc = this.peso/(this.altura*this.altura);
        if (imc<20){
            return -1;
        } else if (imc>=20 && imc<=25) {
            return 0;
        } else {
            return 1;
        }
    };

    public boolean esMayorDeEdad(){
      return this.edad>=18;
    };

    public String toString(){
        return (this.nombre+" tiene "+ this.edad+" años y DNI "+this.dni+". Pesa "+peso+" kg y tiene una altura de "+altura+" m.");
    };

}
