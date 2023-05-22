public class PracticaExcepciones {
    int a = 0;
    int b = 300;

    int calcularCociente(){
        try {
            if(a == 0)
                throw new IllegalArgumentException("No se puede dividir por cero");
        }catch (IllegalArgumentException exception){
            System.out.println("\n Se ha producido un error");
        }finally {
            System.out.println("\n Programa finalizado");
        }
        return 0;
    }
}
