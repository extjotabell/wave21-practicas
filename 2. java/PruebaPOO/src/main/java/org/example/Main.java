package org.example;

public class Main {
    public static void main(String[] args) {
        Persona personaVacia = new Persona();
        Persona personaCompleta = new Persona("Juan Perez", 25,"123456", 56.5, 1.8);
        Persona personaAMedias = new Persona("Carlos Garcia", 30, "345678");

        //Persona personaInvalida = new Persona("Ana Perez", 29);
        // no es valido porque no existe constructor con dichos parametros

        System.out.println(personaCompleta.toString());
        if (personaCompleta.esMayorDeEdad()){
            System.out.println("Es mayor de edad");
        } else {
            System.out.println("Es menor de edad");
        }
        System.out.print("Segun su IMC tiene: ");
        switch (personaCompleta.calcularIMC()){
            case -1:
                System.out.println("Bajo peso");
                break;
            case 0:
                System.out.println("Peso saludable");
                break;
            case 1:
                System.out.println("Sobrepeso");
                break;
        };

    }
}