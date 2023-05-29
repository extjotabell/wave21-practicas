import clases.Serie2;
import clases.Serie3;

public class Main {
    public static void main(String[] args) {
        Serie2 serie2= new Serie2();
        serie2.setValorInicial(2);
        serie2.valorSiguiente();
        serie2.valorSiguiente();
        System.out.println(serie2.valorSiguiente());
        serie2.reiniciarSerie();
        System.out.println(serie2.valorSiguiente());

        Serie3 serie3= new Serie3();
        serie3.setValorInicial(3);
        serie3.valorSiguiente();
        serie3.valorSiguiente();
        serie3.valorSiguiente();
        System.out.println(serie3.valorSiguiente());
        serie3.reiniciarSerie();
        System.out.println(serie3.valorSiguiente());
    }
}