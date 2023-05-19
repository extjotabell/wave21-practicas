package org.example;

public class Persona {

    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona() {
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

    //me pidió que toString lo haga publico sino crasheaba con el método toString de .Object

    public String toString(){
       return "Nombre: " + nombre + "dni"  + dni + " edad: " + edad + "altura " + altura + "peso " + peso;
    }
    public boolean esMayorDeEdad() {
        return edad >=18;
    }
    public int calcularIMC(){
        double imc = peso / Math.pow(altura, 2);
        int ret;
        if(imc < 20){
            ret = -1;
        }else if(imc <=25){
            ret = 0;
        }else{
            ret=1;
        }
        System.out.println("EL IMC CALCULDO ES:" + imc + "Y SE RETORNA " + ret);
        return ret;

    }

    public String getNombre() {
        return nombre;
    }
}
