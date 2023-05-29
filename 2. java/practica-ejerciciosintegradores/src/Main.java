
public class Main {
    public static void main(String[] args) {
        SerieInteger prueba = new SerieInteger(1,2);

        prueba.devolverSiguiente();
        prueba.devolverSiguiente();
        prueba.devolverSiguiente();
        prueba.devolverSiguiente();

        prueba.reiniciarValorSerie();

        prueba.devolverSiguiente();

    }
}