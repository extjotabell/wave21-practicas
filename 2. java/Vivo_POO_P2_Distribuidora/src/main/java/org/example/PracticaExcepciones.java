package org.example;

public class PracticaExcepciones {
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

    private int a;
    private int b;
    public PracticaExcepciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public double calcularCociente1(){
        double result = 0;
        try{
            result = (double) b / a;
        }catch (ArithmeticException e){
            System.out.println("Se ha producido un error");
            result = -1;
        }
        finally {
            System.out.println("Programa finalizado");
        }
        return result;
    }

    public double calcularCociente2(){
        double result = 0;
        try{
            result = b / a;
        }catch (IllegalArgumentException e){
            System.out.println("No se puede dividir por cero");
            result = -1;
        }
        finally {
            System.out.println("Programa finalizado");
        }
        return result;
    }

}

