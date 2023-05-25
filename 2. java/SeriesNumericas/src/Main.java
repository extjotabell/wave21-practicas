// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        SerieUno serieUno = new SerieUno(0);
        for (int i = 0; i < 10; i++) {
            System.out.println(serieUno.obtenerValorSiguiente());
        }

        SerieUno inicialUno = new SerieUno(1);
        for (int i = 0; i < 10; i++) {
            System.out.println(inicialUno.obtenerValorSiguiente());
        }

        SerieDos serieDos = new SerieDos(0);
        for (int i = 0; i < 10; i++) {
            System.out.println(serieDos.obtenerValorSiguiente());
        }
    }
}