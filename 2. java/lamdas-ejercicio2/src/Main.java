import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
* Inicia creando una clase Vehículo con los atributos modelo, marca y costo. Luego crea una clase garaje con los atributos id o identificador único y una lista de vehículos. Crea además los constructores de las clases y los métodos Setter y Getter.
* Haz una clase Main con el método main para representar un escenario donde se crea una instancia de la clase garaje con una lista de vehículos según la tabla.
* Haciendo uso del método sort en la lista de Vehículos con expresiones lambda, obtén una lista de vehículos ordenados por precio de menor a mayor, imprime por pantalla el resultado
* De la misma forma que el ejercicio anterior, imprime una lista ordenada por marca y a su vez por precio.
* Se desea extraer una lista de vehículos con precio no mayor a 1000, luego otra con
* precios mayor o igual 1000 y por último, obtén el promedio total de precios de toda la lista de vehículos.
*
* */
public class Main {
    public static void main(String[] args) {
        Garaje flota = new Garaje();

        Vehiculo a1 = new Vehiculo("Ford", "Fiesta", 1000);
        flota.agregarVehiculo(a1);

        Vehiculo a2 = new Vehiculo("Ford", "Focus", 1200);
        flota.agregarVehiculo(a2);

        Vehiculo a3 = new Vehiculo("Ford", "Explorer", 2500);
        flota.agregarVehiculo(a3);

        Vehiculo a4 = new Vehiculo("Fiat", "Uno", 500);
        flota.agregarVehiculo(a4);

        Vehiculo a5 = new Vehiculo("Fiat", "Cronos", 1000);
        flota.agregarVehiculo(a5);

        Vehiculo a6 = new Vehiculo("Fiat", "Torino", 1250);
        flota.agregarVehiculo(a6);

        Vehiculo a7 = new Vehiculo("Chevrolet", "Aveo", 1250);
        flota.agregarVehiculo(a7);

        Vehiculo a8 = new Vehiculo("Chevrolet", "Spin", 2500);
        flota.agregarVehiculo(a8);

        Vehiculo a9 = new Vehiculo("Toyota", "Corolla", 1200);
        flota.agregarVehiculo(a9);

        Vehiculo a10 = new Vehiculo("Toyota", "Fortuner", 3000);
        flota.agregarVehiculo(a10);

        Vehiculo a11 = new Vehiculo("Renault", "Logan", 950);
        flota.agregarVehiculo(a11);

       flota.getListado().stream()
               .sorted((x,y)-> x.getPrecio().compareTo(y.getPrecio()))
               .forEachOrdered(auto-> System.out.println(auto.getMarca() + " " + auto.getModelo() + " "+ auto.getPrecio()));

       System.out.println("\n\n\n");

       List<Vehiculo> listaAutos = flota.getListado();
       //listado ordenado por Marca y luego por precio
        //osea cada marca esta ordenada por precio
       List<Vehiculo> listaOrdenada = listaAutos.stream()
               .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getPrecio))
               .collect(Collectors.toList());

       listaOrdenada.stream().forEach(auto -> System.out.println(auto.getMarca() +
            " " + auto.getModelo() + " " + auto.getPrecio() ));

       //listado de autos con precios Menor a 1000
       List<Vehiculo> listaPrecioMenorA1000 = listaAutos.stream()
               .filter(vehiculo -> vehiculo.getPrecio() < 1000 )
               .collect(Collectors.toList());

       //Listado de autos con precios Mayor o igual a 1000
       List<Vehiculo> listaPreciosMayor1000 = listaAutos.stream()
               .filter(vehiculo -> vehiculo.getPrecio() >= 1000)
               .collect(Collectors.toList());
       //Promedio total de precios de toda la lista

        double listaPrecios = listaAutos.stream()
                .mapToInt(auto -> auto.getPrecio())
                .average()
                .orElse(0.0);




    }


}