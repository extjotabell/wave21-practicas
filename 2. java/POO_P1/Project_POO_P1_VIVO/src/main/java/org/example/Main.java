package org.example;

import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Pedro", 18, "11111111");
        Persona persona3 = new Persona("Sara", 22, "11111112", 50, 1.65);
        //Persona persona4 = new Persona("Guille", 34);

        System.out.println(persona3.calcularIMC());
        System.out.println(persona3.esMayorDeEdad());
        System.out.println(persona3.informacionPersona());

    }

    public static class Persona {
        String nombre;
        int edad;
        String dni;
        double peso;
        double altura;

        public Persona() {

        };

        public Persona(String nom, int ed, String dn) {
            this.nombre = nom;
            this.edad = ed;
            this.dni = dn;
        }

        public Persona(String nom, int ed, String dn, double pes, double alt) {
            this.nombre = nom;
            this.edad = ed;
            this.dni = dn;
            this.peso = pes;
            this.altura = alt;
        }

        public int calcularIMC() {
            double pesoTotal;
            pesoTotal = (peso/(Math.pow(2, altura)));
            int resultado = 0;
            if (pesoTotal < 20) {
                resultado =  -1;
            }
            if (pesoTotal == 20 && pesoTotal <= 25 ) {
                resultado = 0;
            }
            if (pesoTotal > 25) {
                resultado = 1;
            }
            return resultado;
        }

        public boolean esMayorDeEdad() {
            if (edad > 18) {
               return true;
            }
            return false;
        }

        public String informacionPersona() {
            if (calcularIMC() == -1) {
                return "El IMC de " + nombre + " es Bajo peso" + " la persona es mayor de 18: " + esMayorDeEdad();
            } else if (calcularIMC() == 0) {
                return "El IMC de " + nombre + " es Peso saludable" + " la persona es mayor de 18: " + esMayorDeEdad();
            } else if (calcularIMC() == 1) {
                return "El IMC de " + nombre + " es Sobrepeso" + " la persona es mayor de 18: " + esMayorDeEdad();
            }
            return "fallo";
        }
    }
}