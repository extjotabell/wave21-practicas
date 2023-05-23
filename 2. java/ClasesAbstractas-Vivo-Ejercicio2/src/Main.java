import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear Personas:
        Persona persona1 = new Persona("Juan", "Gómez");
        Persona persona2 = new Persona("María", "López");
        Persona persona3 = new Persona("Carlos", "González");
        Persona persona4 = new Persona("Laura", "Martínez");

        // Creación de habilidades
        List<String> habilidades1 = new ArrayList<>();
        habilidades1.add("Java");
        habilidades1.add("SQL");
        habilidades1.add("Comunicación");

        List<String> habilidades2 = new ArrayList<>();
        habilidades2.add("Python");
        habilidades2.add("Machine Learning");
        habilidades2.add("Inglés");

        List<String> habilidades3 = new ArrayList<>();
        habilidades3.add("C++");
        habilidades3.add("Algoritmos");
        habilidades3.add("Liderazgo");

        List<String> habilidades4 = new ArrayList<>();
        habilidades4.add("HTML");
        habilidades4.add("CSS");
        habilidades4.add("JavaScript");

        // Creación de currículums
        Curriculum curriculum1 = new Curriculum(persona1, habilidades1);
        Curriculum curriculum2 = new Curriculum(persona2, habilidades2);
        Curriculum curriculum3 = new Curriculum(persona3, habilidades3);
        Curriculum curriculum4 = new Curriculum(persona4, habilidades4);

        // Creación de informes
        Informe informe1 = new Informe("Informe 1", 10, persona1, persona2);
        Informe informe2 = new Informe("Informe 2", 8, persona2, persona3);
        Informe informe3 = new Informe("Informe 3", 12, persona3, persona4);
        Informe informe4 = new Informe("Informe 4", 6, persona4, persona1);

        // Creación de libros en formato PDF
        LibroPdf libro1 = new LibroPdf(200, "Juan Gómez", "El arte de programar", "Informática");
        LibroPdf libro2 = new LibroPdf(300, "María López", "La sombra del viento", "Novela");
        LibroPdf libro3 = new LibroPdf(150, "Carlos González", "Introducción a la estadística", "Ciencias");
        LibroPdf libro4 = new LibroPdf(250, "Laura Martínez", "Cocina fácil y rápida", "Culinaria");

        List<Documento> impresora = new ArrayList<>();

        impresora.add(libro1);
        impresora.add(libro2);
        impresora.add(libro3);
        impresora.add(libro4);

        impresora.add(informe1);
        impresora.add(informe2);
        impresora.add(informe3);
        impresora.add(informe4);

        impresora.add(curriculum1);
        impresora.add(curriculum2);
        impresora.add(curriculum3);
        impresora.add(curriculum4);

        for (Documento doc : impresora) {
            System.out.println(doc.imprimir());
        }

    }
}