package POO_P2_ej1;

public class PracticaExcepciones {
    private int dividendo;
    private int divisor;

    public PracticaExcepciones(int dividendo, int divisor) {
        this.dividendo = dividendo;
        this.divisor = divisor;
    }

    public double dividir(){
        double division = -1;
        try{
            division = dividendo/divisor;
        }catch (ArithmeticException exception){
            throw new IllegalArgumentException("No se puede dividir por cero");
        }

        return  division;
    }
}
