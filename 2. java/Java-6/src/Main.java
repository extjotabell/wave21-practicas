import java.util.List;

public class Main {
    public static void printDocument(Imprimble document){
        document.imprimir();
    }

    public static void main(String[] args) {
        Curriculums cv = new Curriculums("Matias Tato", 23, List.of("Habilidad1", "Habilidad2", "Habilidad3"));
        PDF pdf = new PDF(156, "Pepito", "Las historias de Pepito", "Terror");
        Informes informe = new Informes("Texto grande", 1, "Ricardo", "Jose");

        printDocument(cv);
        printDocument(pdf);
        printDocument(informe);
    }
}