import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Persona charlie = new Persona("Charlie", "Schiaffino", 25, 15030);
        List habilidades = new ArrayList();
        Informes informe = new Informes("Hola como estás, mi nombre es charlie y estamos hablando de algo", 54, "Perez", "Gonzalez");
        LibroPdf libroPdf = new LibroPdf(40, "Java 1.1", "Fernandez", "Terror");
        Curriculum curriculum = new Curriculum(charlie, habilidades);

        informe.print();
        libroPdf.print();
        curriculum.print();

        System.out.println("==========> Utilizando Interfaces  <=========");
        Impresora.imprimir(informe);
        Impresora.imprimir(libroPdf);
        Impresora.imprimir(curriculum);
    }
}
