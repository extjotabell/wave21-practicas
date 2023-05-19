package org.example;

import java.util.LinkedList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        LinkedList <Inscripcion> inscripciones = new LinkedList<>();
        Categoria cat1 = new Categoria(0, "Circuito chico", "2 km por selva y arroyos.");
        Categoria cat2 = new Categoria(1, "Circuito medio", "5 km por selva, arroyos y barro.");
        Categoria cat3 = new Categoria(2, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra.");
        Persona p1 = new Persona();
        Scanner teclado = new Scanner(System.in);
        System.out.println("INSCRIPCIONES:");
        System.out.println("DNI:");
        p1.setNombre(teclado.nextLine());
        System.out.println("NOMBRE:");
        p1.setNombre(teclado.nextLine());
        System.out.println("APELLIDO:");
        p1.setApellido(teclado.nextLine());
        System.out.println("EDAD:");
        p1.setEdad(teclado.nextInt());
        System.out.println("NUMERO DE PARTICIPANTE:");
        p1.setNúmeroDeParticipante(teclado.nextInt());
        System.out.println("CELULAR:");
        p1.setCelular(teclado.nextInt());
        System.out.println("NUMERO DE EMERGENCIA:");
        p1.setNúmeroDeEmergencia(teclado.nextInt());
        System.out.println("GRUPO SANGUINEO:");
        p1.setGrupoSanguíneo(teclado.nextLine());

        //System.out.println(p1.getNombre());

    }
}