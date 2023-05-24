import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {

        //Reservas
        Reserva reservaHotel1 = new Hotel(4500d);
        Reserva reservaTransporte1 = new Transporte(3000d);
        Reserva reservaBoletos1 = new Boletos(2000d);
        Reserva reservaComida1 = new Comida(1500d);

        //Creación de clientes
        Cliente cliente1 = new Cliente(1,"Juan Perez","39274738");
        Cliente cliente2 = new Cliente(2,"Jose Juan","4491234567");
        Cliente cliente3 = new Cliente(3,"Maria Fernandez","233456789");
        Cliente cliente4 = new Cliente(4,"Lola Nuñez","123456789");
        Cliente cliente5 = new Cliente(5,"Camilo Soto","346768890");
        Cliente cliente6 = new Cliente(6,"Ana Brenda","123987005");

        //Creación de localizadores
        Localizador localizador1 = new Localizador(cliente1, Arrays.asList(reservaComida1,reservaHotel1));
        Localizador localizador2 = new Localizador(cliente4, Arrays.asList(reservaComida1,reservaHotel1));
        Localizador localizador3 = new Localizador(cliente1, Arrays.asList(reservaComida1,reservaHotel1,reservaBoletos1,reservaTransporte1));
        Localizador localizador4 = new Localizador(cliente3, Arrays.asList(reservaTransporte1,reservaHotel1));
        Localizador localizador6 = new Localizador(cliente2, Arrays.asList(reservaHotel1,reservaBoletos1));
        Localizador localizador7 = new Localizador(cliente3, Arrays.asList(reservaHotel1,reservaComida1));
        Localizador localizador8 = new Localizador(cliente2, Arrays.asList(reservaHotel1,reservaBoletos1,reservaTransporte1));
        Localizador localizador9 = new Localizador(cliente2, Arrays.asList(reservaHotel1,reservaBoletos1,reservaTransporte1,reservaComida1));

        //creación del repositorio
        Repositorio repositorio = new Repositorio();
        repositorio.agregarLocalizador(localizador1);
        repositorio.agregarLocalizador(localizador2);
        repositorio.agregarLocalizador(localizador3);
        repositorio.agregarLocalizador(localizador4);
        repositorio.agregarLocalizador(localizador6);
        repositorio.agregarLocalizador(localizador7);
        repositorio.agregarLocalizador(localizador8);
        repositorio.agregarLocalizador(localizador9);


        //lista un localizador con un paquete completo para un cliente
        Localizador localizador10 = new Localizador(cliente5, Arrays.asList(reservaHotel1,reservaBoletos1,reservaTransporte1,reservaComida1));
        repositorio.agregarLocalizador(localizador10);
        System.out.println("LOCALIZADOR CON TODOS LOS SERVICIOS");
        localizador10.imprimirLocalizador();

        //listar los localizadores de un cliente
        Localizador localizador11 = new Localizador(cliente5, Arrays.asList(reservaHotel1,reservaHotel1,reservaBoletos1,reservaBoletos1));
        repositorio.agregarLocalizador(localizador11);
        System.out.println("\nLOCALIZADOR CON DOS RESERVAS DE HOTEL Y DOS DE BOLETOS DE AVIÓN");
        localizador11.imprimirLocalizador();

        //crea localizador con una sola reserva
        Localizador localizador5 = new Localizador(cliente5, List.of(reservaComida1));
        repositorio.agregarLocalizador(localizador5);
        System.out.println("\nLOCALIZADOR CON UN SOLO SERVICIO");
        localizador5.imprimirLocalizador();

        //lista todos los localizadores de un cliente
        repositorio.mostrarLocalizadoresPorCliente(cliente5);




    }
}