public class PracticaExcepciones {
    private int a = 0;
    private int b = 0;

    public int cociente() {
        try {
            if (b==0){
                throw new IllegalArgumentException("no dividas por 0 , tonto");
            }
            else{
                int c = b / a;
                return c;
            }

        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();

        } finally {
            System.out.println("Programa finalizado");
        }
        return 0;
    }
}