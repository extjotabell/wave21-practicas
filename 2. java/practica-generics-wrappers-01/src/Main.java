import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Vehiculo autos[] = {
                new Vehiculo("Ford","Fiesta",1000),
                new Vehiculo("Ford","Focus",1200),
                new Vehiculo("Ford","Explorer",2500),
                new Vehiculo("Fiat","Uno",500),
                new Vehiculo("Fiat","Cronos",1000),
                new Vehiculo("Fiat","Torino",1250),
                new Vehiculo("Chevrolet","Aveo",1250),
                new Vehiculo("Chevrolet","Spin",2500),
                new Vehiculo("Toyota","Corola",1200),
                new Vehiculo("Toyota","Fortuner",3000),
                new Vehiculo("Renault","Logan",950)
        };

        List<Vehiculo> vehiculos = Arrays.asList(autos);

        System.out.println("----Ejercicio 3------");

        Comparator<Vehiculo> ordenarPrecio = Comparator.comparing(Vehiculo::getCosto);

        List<Vehiculo> autosOrdenadosPorPrecio = vehiculos.stream()
                    .sorted(ordenarPrecio).collect(Collectors.toList());

        autosOrdenadosPorPrecio.forEach(auto-> System.out.println(auto.costo));

        System.out.println("----Ejercicio 4------");

        Comparator<Vehiculo> ordenarMarca = Comparator.comparing((Vehiculo::getMarca));

        List<Vehiculo> autosOrdPorMarcaYPrecio = autosOrdenadosPorPrecio.stream()
                .sorted(ordenarMarca)
                .collect(Collectors.toList());

        autosOrdPorMarcaYPrecio.forEach(auto-> System.out.println(auto.costo));

        System.out.println("----Ejercicio 5------");
        System.out.println("a)");
        List<Vehiculo> autosConPrecioMenor1000 = vehiculos.stream()
                .filter(auto -> auto.costo <1000)
                .collect(Collectors.toList());

        autosConPrecioMenor1000.forEach(auto->System.out.println(auto.costo));

        System.out.println("b)");
        List<Vehiculo> autosConPrecioMayorIgual1000 = vehiculos.stream()
                .filter(auto -> auto.costo >=1000)
                .collect(Collectors.toList());

        autosConPrecioMayorIgual1000.forEach(auto->System.out.println(auto.costo));
        System.out.println("c)");
        int suma;
        double promedio;

        promedio = vehiculos.stream()
                .map(Vehiculo::getCosto)
                .toList() //Obtuve la lista de precios
                .stream().mapToDouble(n->n).average().orElse(0D);
        System.out.println("El promedio es: " + Math.round(promedio));
    }
}