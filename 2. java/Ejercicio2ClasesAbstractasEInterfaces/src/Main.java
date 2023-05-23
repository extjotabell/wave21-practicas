// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> skills = new ArrayList<String>();
        skills.add("Java");
        skills.add("SQL");
        skills.add("English");
        Curriculums curr1 = new Curriculums("Javier", 24, skills);

        LibrosenPDF lib1 = new LibrosenPDF(1, "John Lorem", "Lorem ipsum", "Latin");
        Informes inf1 = new Informes("orem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", 1, "Roberto", "Carlos");

        Imprimible.imprimirDocumento(inf1);
        Imprimible.imprimirDocumento(lib1);
        Imprimible.imprimirDocumento(curr1);

    }
}