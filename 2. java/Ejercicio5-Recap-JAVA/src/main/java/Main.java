import java.util.List;
class Main {
    public static void main(String[] args) {
        Vehiculo vehiculo1 = new Vehiculo("Fiesta", "Ford", 1000);
        Vehiculo vehiculo2 = new Vehiculo("Focus", "Ford", 1200);
        Vehiculo vehiculo3 = new Vehiculo("Clio", "Renault", 900);
        Vehiculo vehiculo4 = new Vehiculo("Golf", "Volkswagen", 1500);

        Garaje garaje = new Garaje(1);
        garaje.getVehiculos().add(vehiculo1);
        garaje.getVehiculos().add(vehiculo2);
        garaje.getVehiculos().add(vehiculo3);
        garaje.getVehiculos().add(vehiculo4);

        // Obtener lista de vehículos con precio no mayor a 1000
        List<Vehiculo> vehiculosPrecioMenorA1000 = garaje.obtenerVehiculosPrecioMenorA(1000);
        System.out.println("Vehículos con precio menor a 1000:");
        for (Vehiculo vehiculo : vehiculosPrecioMenorA1000) {
            System.out.println("Marca: " + vehiculo.getMarca());
            System.out.println("Modelo: " + vehiculo.getModelo());
            System.out.println("Precio: " + vehiculo.getCosto());
            System.out.println();
        }

        // Obtener lista de vehículos con precio mayor o igual a 1000
        List<Vehiculo> vehiculosPrecioMayorIgualA1000 = garaje.obtenerVehiculosPrecioMayorIgualA(1000);
        System.out.println("Vehículos con precio mayor o igual a 1000:");
        for (Vehiculo vehiculo : vehiculosPrecioMayorIgualA1000) {
            System.out.println("Marca: " + vehiculo.getMarca());
            System.out.println("Modelo: " + vehiculo.getModelo());
            System.out.println("Precio: " + vehiculo.getCosto());
            System.out.println();
        }

        // Obtener promedio total de precios de los vehículos
        double promedioPrecios = garaje.obtenerPromedioPrecios();
        System.out.println("Promedio total de precios de los vehículos: " + promedioPrecios);
    }
}
