package Ejercicio_1;

import Ejercicio_1.clases.Basic;
import Ejercicio_1.clases.Cliente;
import Ejercicio_1.clases.Ejecutivo;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Ejecutivo cl1 = new Ejecutivo("Demian");
        Basic cl2 = new Basic("Jorge");

        cl1.realizarDeposito();
        cl1.realizarTransferencia();
    }
}