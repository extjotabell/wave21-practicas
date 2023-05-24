import Clases.*;

import java.awt.image.RescaleOp;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Carga de Clientes.
        List<Cliente> clientes = new ArrayList<>();

        //
        Cliente cliente1 = new Cliente("Nombre1", "Apellido1", "DNI1");
        Cliente cliente2 = new Cliente("Nombre2", "Apellido2", "DNI2");
        Cliente cliente3 = new Cliente("Nombre3", "Apellido3", "DNI3");
        Cliente cliente4 = new Cliente("Nombre4", "Apellido4", "DNI4");
        Cliente cliente5 = new Cliente("Nombre5", "Apellido5", "DNI5");

        // Carga de Productos.
        Hotel hotel = new Hotel(20.0, "Shao Shao");
        Hotel hotel1 = new Hotel(30.0, "Grand Plaza");
        Boleto boleto = new Boleto(10.0, "Crucero del Norte");
        Boleto boleto1 = new Boleto(20.0, "Costera");
        Restaurant restaurant = new Restaurant(5.0, "Daka");
        Transporte transporte = new Transporte(25.0, "Transfer");

        // PUNTO NUMERO 1:

        // Crear localizador cliente 1:
        Localizador localizador = new Localizador(1);
        localizador.agregarProducto(hotel);
        localizador.agregarProducto(boleto);
        localizador.agregarProducto(restaurant);
        localizador.agregarProducto(transporte);

        // Agreamos localizador AL CLIENTE
        cliente1.agregarLocalizador(localizador);

        // Quiero imprimir el valor total.
        System.out.print("El total del punto 1 es: ");
        cliente1.imprimirLocalizador(1);


        // PUNTO NUMERO 2:
        Localizador localizador1 = new Localizador(2);
        localizador1.agregarProducto(hotel);
        localizador1.agregarProducto(hotel1);
        localizador1.agregarProducto(boleto);
        localizador1.agregarProducto(boleto1);
        // Agreamos localizador AL CLIENTE
        cliente1.agregarLocalizador(localizador1);
        // Quiero imprimir el valor total.
        System.out.print("El total del punto 2 es: ");
        cliente1.imprimirLocalizador(2);

        // PUNTO NUMERO 3:
        Localizador localizador2 = new Localizador(3);
        localizador2.agregarProducto(hotel);
        localizador2.agregarProducto(hotel1);
        localizador2.agregarProducto(boleto);
        localizador2.agregarProducto(boleto1);
        cliente1.agregarLocalizador(localizador2);
        // Quiero imprimir el valor total.
        System.out.print("El total del punto 3 es: ");
        cliente1.imprimirLocalizador(3);
    }
}