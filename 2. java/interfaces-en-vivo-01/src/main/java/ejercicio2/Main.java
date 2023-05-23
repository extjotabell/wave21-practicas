package ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Jose", "Gonzalez");
        Persona persona2 = new Persona("Juan", "Perez");
        Persona persona3 = new Persona("Maria", "Gutierrez");
        Persona persona4 = new Persona("Pedro", "Benzema");

        List<String> habilidadesPersona1 = new ArrayList<>();
        habilidadesPersona1.add("java");
        habilidadesPersona1.add("c#");

        List<String> habilidadesPersona2 = new ArrayList<>();
        habilidadesPersona2.add("comunicación");
        habilidadesPersona2.add("inglés");

        List<String> habilidadesPersona3 = new ArrayList<>();
        habilidadesPersona3.add("clojure");
        habilidadesPersona3.add("c");

        List<String> habilidadesPersona4 = new ArrayList<>();
        habilidadesPersona4.add("go");
        habilidadesPersona4.add("solid");

        Documento curriculum1 = new Curriculum(persona1, habilidadesPersona1);
        Documento curriculum2 = new Curriculum(persona2, habilidadesPersona2);
        Documento curriculum3 = new Curriculum(persona3, habilidadesPersona3);
        Documento curriculum4 = new Curriculum(persona4, habilidadesPersona4);

        Documento libroPDF1 = new LibroEnPDF(100, "William", "Romeo y Julieta", "Romance");
        Documento libroPDF2 = new LibroEnPDF(150, "Peter", "Historia del Rock", "Musica");
        Documento libroPDF3 = new LibroEnPDF(200, "Carlos", "Baloncesto para novatos", "Deportes");
        Documento libroPDF4 = new LibroEnPDF(50, "Jimmy", "Introducción a Java", "Programación");

        Documento informe1 = new Informe("texto1", 20, persona1, persona2);
        Documento informe2 = new Informe("texto2", 25, persona2, persona3);
        Documento informe3 = new Informe("texto3", 15, persona3, persona4);
        Documento informe4 = new Informe("texto4", 10, persona4, persona1);

        List<Documento> documentos = new ArrayList<>();
        documentos.add(curriculum1);
        documentos.add(curriculum2);
        documentos.add(curriculum3);
        documentos.add(curriculum4);

        documentos.add(libroPDF1);
        documentos.add(libroPDF2);
        documentos.add(libroPDF3);
        documentos.add(libroPDF4);

        documentos.add(informe1);
        documentos.add(informe2);
        documentos.add(informe3);
        documentos.add(informe4);

        documentos.forEach(documento -> {
            System.out.println(documento.imprimir());
        });
    }
}