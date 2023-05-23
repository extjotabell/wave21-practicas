package ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> skills = new ArrayList<String>();
        skills.add("Python");
        skills.add("PostgreSQL");
        Curriculum curr1 = new Curriculum("Cristóbal", 24, skills);

        LibroEnPdf lib1 = new LibroEnPdf(1, "Autor libro", "Titulo del libro", "Genero común");
        Informe inf1 = new Informe("Este es el texto del informe.", 2, "Autor informe", "Revisor génerico");

        Imprimible.imprimirDocumento(inf1);
        Imprimible.imprimirDocumento(lib1);
        Imprimible.imprimirDocumento(curr1);
    }
}