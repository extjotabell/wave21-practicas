package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        //Persona vacia
        Persona personaVacia = new Persona();

        //persona con nombre, dni y edad

        Persona personaIncompleta = new Persona("Mercedes", 23, "1234567");

        //persona completa

        Persona personaCompleta = new Persona("Mercedes", 23, "12344", 65.0, 1.75);

        //no existen constructores con dos parámetros únicamanete entonces va a romper

        //-----PRUEBA----//

        //imc

        int imc = personaCompleta.calcularIMC();
        String mensajeIMC;

        if(imc == -1){
            mensajeIMC = "BAJO PESO";
        }else if(imc == 0) {
            mensajeIMC = "PESO SALUDABLE";
        }else{
            mensajeIMC = "SOBREPESO";
        }

        System.out.println(mensajeIMC);



        //mayoria de edad
        boolean mayoriaEdad = personaCompleta.esMayorDeEdad();
        String mensajeMayoriaEdad = personaCompleta.getNombre() + "no es mayor de edad";
        if(mayoriaEdad) mensajeMayoriaEdad = personaCompleta.getNombre() + " es mayor de edad";
        System.out.println(mensajeMayoriaEdad);





    }
}