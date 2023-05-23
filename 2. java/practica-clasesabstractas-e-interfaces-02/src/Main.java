import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("Luz", "Deniz",22);
        List habilidades = new ArrayList<>();
        habilidades.add("Cantar");
        habilidades.add("Bailar");

        Imprimible curriculumLuz = new Curriculum(persona,habilidades);
        Imprimible.imprimirDocumento(curriculumLuz);

        Imprimible libro = new LibroEnPDF(10,"Luz","Mis recuerdos", "Fantasia");
        Imprimible.imprimirDocumento(libro);

        Imprimible informe = new Informe("Lorem ipsum...",2,"Diana","Luz");
        Imprimible.imprimirDocumento(informe);

    }
}