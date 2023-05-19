public class PracticaExcepciones {
    int a;
    int b;

    public PracticaExcepciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public double calcularCociente(){
        double result = 0;
        try{
            result = b / a;
            return result;
        }catch (ArithmeticException e){
            e.printStackTrace();
            System.out.println("Se ha producido un error");
            return -1;
        }
        finally {
            System.out.println("Programa finalizado");

        }
    }
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
