import Clases.SerieDouble;
import Clases.SerieEntera;

public class Main {
    public static void main(String[] args) {
        SerieEntera serie1 = new SerieEntera(2);
        SerieDouble serie2 = new SerieDouble(3D);
        SerieDouble serie3 = new SerieDouble(1.5);

        System.out.println("-----");
        System.out.println("Serie Entera: Repetimos 5 veces");
        for (int i = 0; i < 5; i++){
            System.out.println(serie1.valorSiguiente());
        }
        System.out.println("-----");
        System.out.println("Serie Entera: Establecemos Nuevo Numero / Repetimos 5 veces");
        serie1.establecerValorInicio(5);
        for (int i = 0; i < 5; i++){
            System.out.println(serie1.valorSiguiente());
        }

        System.out.println("-----");
        System.out.println("Serie Double: Repetimos 5 veces");
        for (int i = 0; i < 5; i++){
            System.out.println(serie2.valorSiguiente());
        }
        System.out.println("-----");
        System.out.println("Serie Double: Establecemos Nuevo Numero / Repetimos 5 veces");
        serie2.establecerValorInicio(5D);
        for (int i = 0; i < 5; i++){
            System.out.println(serie2.valorSiguiente());
        }

        System.out.println("-----");
        System.out.println("Serie Double 2: Repetimos 5 veces");
        for (int i = 0; i < 5; i++){
            System.out.println(serie3.valorSiguiente());
        }
        System.out.println("-----");
        System.out.println("Serie Double: Establecemos Nuevo Numero / Repetimos 5 veces");
        serie3.establecerValorInicio(2.5);
        for (int i = 0; i < 5; i++){
            System.out.println(serie3.valorSiguiente());
        }

    }
}