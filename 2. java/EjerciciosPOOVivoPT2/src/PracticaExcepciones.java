// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class PracticaExcepciones {
    int a = 0;
    int b = 300;

    public PracticaExcepciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int calcuar(){
        return  this.b / this.a;
    }

    public static void main(String[] args) {
        PracticaExcepciones practicaExcepciones = new PracticaExcepciones(0, 300);
        try {
            practicaExcepciones.calcuar();
        }catch (IllegalArgumentException e) {
            System.out.println("Se ha producido un error");
        }finally {
            System.out.println("Programa finalizado");
        }
    }
}