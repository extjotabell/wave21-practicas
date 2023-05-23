package interfazclase;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Figura cuadrado = new Cuadrado(5, 5);
        Figura triangulo = new Triangulo(4, 3);
        Figura circulo = new Circulo(5);
        List<Figura> figuras= new ArrayList<>();
        figuras.add(cuadrado);
        figuras.add(triangulo);
        figuras.add(circulo);

        double areaTotal = 0;
        for (Figura figura: figuras){
            areaTotal += figura.calcularArea();
        }

        System.out.println("areaTotal: " + areaTotal);
    }
}
