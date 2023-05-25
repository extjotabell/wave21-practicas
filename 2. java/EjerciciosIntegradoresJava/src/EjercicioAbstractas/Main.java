package EjercicioAbstractas;

public class Main {
    public static void main(String[] args) {

        Prototipo serieDos = new SerieDeDos();
        Prototipo serieTres = new SerieDeTres();

       // serieDos.reestablecerSerie(1);
        System.out.println("Valor actual: " + serieDos.getValorActual());

        System.out.println("Valor siguiente: " + serieDos.valorSiguiente());

    }
}