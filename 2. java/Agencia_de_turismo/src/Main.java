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
        Cliente cliente2 = new Cliente(7,"Jose Juan","4491234567");
        Cliente cliente3 = new Cliente(2,"Maria Fernandez","233456789");
        Cliente cliente4 = new Cliente(3,"Lola Nuñez","123456789");
        Cliente cliente5 = new Cliente(4,"Camilo Soto","346768890");
        Cliente cliente6 = new Cliente(5,"Ana Brenda","123987005");

        //Creación de localizadores
        Localizador localizador1 = new Localizador(cliente1, Arrays.asList(reservaComida1,reservaHotel1));
        Localizador localizador2 = new Localizador(cliente4, Arrays.asList(reservaComida1,reservaHotel1));
        Localizador localizador3 = new Localizador(cliente1, Arrays.asList(reservaComida1,reservaHotel1,reservaBoletos1,reservaTransporte1));
        Localizador localizador4 = new Localizador(cliente3, Arrays.asList(reservaTransporte1,reservaHotel1));
        Localizador localizador5 = new Localizador(cliente5, List.of(reservaComida1));
        Localizador localizador6 = new Localizador(cliente2, Arrays.asList(reservaHotel1,reservaBoletos1));

        //creación del repositorio
        Repositorio repositorio = new Repositorio();
        repositorio.agregarLocalizador(cliente1,localizador1);
        repositorio.agregarLocalizador(cliente4,localizador2);
        repositorio.agregarLocalizador(cliente1,localizador3);
        repositorio.agregarLocalizador(cliente3,localizador4);
        repositorio.agregarLocalizador(cliente5,localizador5);
        repositorio.agregarLocalizador(cliente2,localizador6);


    }
}