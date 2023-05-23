package ejercicio_2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Juan", 25);
        List<String> habilidades = new ArrayList<>();
        habilidades.add("Responsable");
        habilidades.add("Inteligente");
        habilidades.add("Puntual");
        habilidades.add("Sociable");
        Informe informe1 = new Informe("Lorem Ipsum", 54,"Perez", "Gonzalez");
        LibroPDF LibroPDF1 = new LibroPDF(40, "Java 1.1", "Fernandez", "terror");
        Curriculum curriculum1 = new Curriculum(persona1, habilidades);

        Impresora.imprimir(informe1);
        Impresora.imprimir(LibroPDF1);
        Impresora.imprimir(curriculum1);
    }
}
