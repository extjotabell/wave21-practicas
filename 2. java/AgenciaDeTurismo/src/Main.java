import Reservas.*;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        RepositorioCliente repoClientes = new RepositorioCliente();
        RepositorioLocalizador repoLocalizadores = new RepositorioLocalizador();

        Cliente cacho = new Cliente("Cacho","3999999");
        repoClientes.add(cacho);

        List<Reserva> reservasCacho = new ArrayList<>();
        reservasCacho.add(new ReservaHotel("Hotel iguazu",1000));
        reservasCacho.add(new ReservaComida("Desayuno",1000));
        reservasCacho.add(new ReservaBoletoViaje("AerolineasArg",1000));
        reservasCacho.add(new ReservaBoletoTransporte("Auto",1000));

        repoLocalizadores.add(cacho,reservasCacho);

        List<Reserva> reservacacho2 = new ArrayList<>();
        reservacacho2.add(new ReservaHotel("Hotel iguazu",1000));
        reservacacho2.add(new ReservaHotel("Hotel iguazu",1000));
        reservacacho2.add(new ReservaBoletoViaje("AerolineasArg",1000));
        reservacacho2.add(new ReservaBoletoViaje("AerolineasArg",1000));
        repoLocalizadores.add(cacho,reservacacho2);

        List<Reserva> reservacacho3 = new ArrayList<>();
        reservacacho3.add(new ReservaBoletoViaje("AerolineasArg",1000));
        repoLocalizadores.add(cacho,reservacacho3);

        System.out.println(repoLocalizadores);

        ServiceLocalizadores.cantidadDeLocalizadores(repoLocalizadores);
        ServiceLocalizadores.cantidadDeReservas(repoLocalizadores);
        ServiceLocalizadores.listarReservasPorTipo(repoLocalizadores);
    }
}