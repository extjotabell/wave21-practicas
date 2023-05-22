import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Distribuidora dist = new Distribuidora();

        ArrayList<Producto> listado = dist.getListado();
        int precioFinal = 0;
        for(Producto elemento : listado){
            precioFinal+= elemento.getPrecio();
        }
        System.out.println("el Total vendido es : "+ precioFinal);
    }
}