package main;

public class Main {
    public static void main(String[] args) {
        Persona personaVacia = new Persona();
        Persona personaCompleta = new Persona("Nicolas Lescano", 38,"25848123",70.5f,71f);
        Persona personaAMedias = new Persona("Carlos Garcia", 38,"40123123");

        //Persona personaInvalida = new Persona("Carlos Garcia", 29);
        //No es valido porque no existe constructor con dichos parametros

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
        }


    }
}

