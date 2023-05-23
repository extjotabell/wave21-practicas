public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public PracticaExcepciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void calcularCociente(){
        try{
            int cociente = b/a;
            System.out.println("El cociente es: " + cociente);
        }catch(ArithmeticException e){
            System.out.println("Se ha producido un error." + e.getMessage());
        } finally {
            System.out.println("Programa finalizado.");
        }
    }

    public static void main(String[] args) {

        System.out.println("Hello world!");
    }
}