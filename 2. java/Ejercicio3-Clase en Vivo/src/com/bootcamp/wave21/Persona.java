package com.bootcamp.wave21;

public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

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

    /*EJERCICIO 5
    En la clase Persona implementaremos los siguientes métodos: cacularIMC(),
    la fórmula para calcularlo es: peso/(altura^2) - (peso expresado en kg y altura en mts),
     si este cálculo devuelve un valor menor que 20, la función debe retornar -1,
     si devuelve un número entre 20 y 25 inclusive para los dos valores, el método debe retornar un 0,
     por último, si devuelve un número mayor que 25 debe retornar un 1. Una vez creado el método anterior,
     agreguemos el método esMayorDeEdad() el cual debe retornar una valor booleano,
     teniendo en cuenta que la mayoría de edad será considerada en este caso, a partir de los 18 años.
     Finalmente agregar un método toString() que va a devolver toda la información de la persona.
    ¡ Recuerda! Puedes ayudarte de los métodos de la clase java.lang.Math para calcular la potencia.
     */

    public int calcularIMC(){
        double valorIMC = this.peso / Math.pow(this.altura, 2) ;

        if(valorIMC < 20){
            return -1;
        }else if (valorIMC <= 25){
            return 0 ;
        }

        return 1;
    }

    public boolean esMayorDeEdad(){
        return this.edad >= 18;
    }

   @Override
    public String toString(){
        return "Nombre: " + this.nombre + " Edad: " + this.edad + " DNI: " + this.dni + " Peso: " + this.peso + " Altura: " + this.altura;
   }
}
