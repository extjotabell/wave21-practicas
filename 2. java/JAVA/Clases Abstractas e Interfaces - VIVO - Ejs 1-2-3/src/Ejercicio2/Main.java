package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> skills = new ArrayList<String>();
        skills.add("Java");
        skills.add("SQL");
        skills.add("English");
        Curriculum curr1 = new Curriculum("Javier", 24, skills);

        LibroEnPDF lib1 = new LibroEnPDF(1, "John Lorem", "Lorem ipsum", "Latin");
        Informe inf1 = new Informe("orem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", 1, "Roberto", "Carlos");

        Imprimible.imprimirDocumento(inf1);
        Imprimible.imprimirDocumento(lib1);
        Imprimible.imprimirDocumento(curr1);
    }
}