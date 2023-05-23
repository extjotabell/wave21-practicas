package PracticaPOO_Vivo2;

import com.sun.tools.javac.Main;

import javax.lang.model.element.ModuleElement;
import java.lang.reflect.Array;

public class Distribuidora {

    public static void main(String[] args) {

        Producto p1 = new Perecedero("Perecedero 1", 50, 3);
        Producto p2 = new NoPerecedero("No perecedero 2", 35, "Alimentación");

        Producto productos[] = {p1,p2};
        int total = 0;
        for (int i = 0; i<productos.length ; i++)
        {
            Producto p = productos[i];
            total = total + p.calcular(5);
        }
        System.out.println("El total de ventas es de: " + total + " pesos.");
    }
}
