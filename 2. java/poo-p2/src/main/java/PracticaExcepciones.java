public class PracticaExcepciones {
    public int a = 0;
    public int b = 300;

    public PracticaExcepciones(){

    }
    public PracticaExcepciones(int a, int b) {
        this.a = a;
        this.b = b;
    }


    public static int calcularCociente(int a, int b){
        int cociente = 0;
        if (a == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero.");
        }
        try{
            cociente = b/a;
        }catch(ArithmeticException e){
            System.out.println("Se ha producido un error.");
        }finally{
            System.out.println("Programa finalizado.");
        }
        return cociente;
    }
}
