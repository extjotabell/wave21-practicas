import model.*;

public class Main {
    public static void main(String[] args) {

        Auto auto1 = new Auto(100,50,30,"123456");
        Auto auto2 = new Auto(200,30,30,"245678");

        Moto moto1 = new Moto(200,60,10,"123950");
        Moto moto2 = new Moto(300,30,10,"456778");

        RepositorioCarrera listaVehiculos = new RepositorioCarrera();

        listaVehiculos.agregarVehiculo(auto1);
        listaVehiculos.agregarVehiculo(auto2);

        Carrera carrera = new Carrera(2000,500,"Carrera1",4,listaVehiculos);

        Vehiculo ganador = carrera.obtenerGanador();

        System.out.println(ganador);

    }
}