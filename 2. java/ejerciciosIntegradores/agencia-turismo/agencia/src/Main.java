import Clases.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Agencia de turismo!");
        // Crear instancias de los repositorios y el calculador de descuento
        RepositorioCliente repositorioCliente = new RepositorioCliente();
        RepositorioLocalizador repositorioLocalizador = new RepositorioLocalizador();
        CalculadorDescuento calculadorDescuento = new CalculadorDescuento();

        // Crear una instancia del servicio de reserva
        ServicioReserva servicioReserva = new ServicioReserva(repositorioCliente, repositorioLocalizador, calculadorDescuento);

        // Crear un cliente
        Cliente cliente = new Cliente("1", "Juan");

        // Crear algunas reservas
        Reserva reserva1 = new Reserva("1", "hotel", 100.0);

        Reserva reserva2 = new Reserva("2", "comida", 50.0);

        Reserva reserva3 = new Reserva("3", "viaje", 200.0);

        Reserva reserva4 = new Reserva("4", "transporte", 75.0);

        // Crear una reserva para el cliente
        servicioReserva.crearReserva(cliente, Arrays.asList(reserva1, reserva2, reserva3, reserva4));
        servicioReserva.crearReserva(cliente, Arrays.asList(reserva1, reserva3, reserva4));

        // Imprimir el localizador
        servicioReserva.imprimirLocalizador("1");
        servicioReserva.imprimirLocalizador("2");
    }
}