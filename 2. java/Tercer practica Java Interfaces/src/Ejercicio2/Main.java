package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Juan", "Perez");
        Persona persona2 = new Persona("Fran", "Sanchez");

        Informe informe = new Informe("Ejercicio2.Informe metereologico", 5, persona1);
        LibroPDF libro = new LibroPDF(4,"Arturo", "Narnia", "Ficcion");

        List<String> listaHabilidades = new ArrayList<>();
        listaHabilidades.add("Agil");
        listaHabilidades.add("Veloz");
        listaHabilidades.add("Amable");

        Curriculum curriculum = new Curriculum(persona2,listaHabilidades);

        System.out.println(informe.imprimir());
        System.out.println(libro.imprimir());
        System.out.println(curriculum.imprimir());
        }
    }
