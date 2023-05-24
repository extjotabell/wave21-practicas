package Main;

import ejercicio_series_numericas.Prototipo;
import ejercicio_series_numericas.SerieBytes;
import ejercicio_series_numericas.SerieNumericaSimple;

public class Main {
    public static void main(String[] args) {
        System.out.println("Serie simple con valor inicial 2.");
        Prototipo<Integer> serieSimple = new SerieNumericaSimple(2);
        imprimirSerie(serieSimple,10);

        System.out.println("Se cambia el valor inicial a 3, y se reinicia la serie.");
        serieSimple.setValorInicial(3);
        serieSimple.reiniciarSerie();
        imprimirSerie(serieSimple,10);

        System.out.println("Serie de Bytes con valor inicial 2 en byte");
        Prototipo<Byte> serieBytes = new SerieBytes((byte)2);
        imprimirSerie(serieBytes,10);

    }

    private static void imprimirSerie(Prototipo serie, int valoresAMostrar){
        System.out.println("Mostrando los primeros " + valoresAMostrar + " valores de la serie.");
        for (int i = 0; i < valoresAMostrar; i++) {
            System.out.print(serie.devolverValorSiguiente());
            if (i < valoresAMostrar - 1) {
                System.out.print(", ");
            } else {
                System.out.println();
            }
        }
    }
}
