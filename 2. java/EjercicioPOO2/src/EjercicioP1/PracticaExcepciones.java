package EjercicioP1;

public class PracticaExcepciones {

    private static int a = 0;
    private static int b = 300;

    public static void division (){
        try{
            int result;
            result = b/a;
        } catch (Exception e){
            throw new IllegalArgumentException("No se puede dividir por 0");
        }
        finally {
            System.out.println("Programa finalizado");
        }
    }
}
