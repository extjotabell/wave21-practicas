package SeriesNumericas;

public class Main {
    public static void main(String[] args) {
        SerieEntera pares = new SerieEntera(2);
        SerieEntera pares2 = new SerieEntera(2,1);
        SerieEntera multiplos3 = new SerieEntera(3);
        SerieDouble doble = new SerieDouble(2.5);

        System.out.println("Punto 1");

        System.out.println(pares.obtenerProximoValor());
        System.out.println(pares.obtenerProximoValor());
        System.out.println(pares.obtenerProximoValor());

        System.out.println("Punto 2");

        System.out.println(pares2.obtenerProximoValor());
        System.out.println(pares2.obtenerProximoValor());
        System.out.println(pares2.obtenerProximoValor());

        System.out.println("Punto 3");

        System.out.println(multiplos3.obtenerProximoValor());
        System.out.println(multiplos3.obtenerProximoValor());
        System.out.println(multiplos3.obtenerProximoValor());

        System.out.println("Doubles");

        System.out.println(doble.obtenerProximoValor());
        System.out.println(doble.obtenerProximoValor());
        System.out.println(doble.obtenerProximoValor());

    }
}
