package Ejercicio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numeroSerie;
        Number nroInicial;
        boolean seguirCalculando = true;
        System.out.println("Ingresar tipo de serie: ");
        Scanner leer = new Scanner(System.in);
        numeroSerie = leer.nextInt();

        System.out.println("Ingresa el valor inicial: ");
        nroInicial = leer.nextInt();

        if(numeroSerie == 2)
        {
            //while (seguirCalculando){
            Prototipo prototipo = new SeriesDeDos<>();
            prototipo.valorInicial(nroInicial);
            prototipo.valorSiguiente(nroInicial);
            System.out.println(nroInicial);

                System.out.println("Volver a ejecutar? S/N");
                String respuesta = leer.next();
                if(respuesta.compareToIgnoreCase("Y") == 0) {
                    
                }

            }

        }
    }
}