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
        reservasCacho.add(new ReservaHotel("Hotel iguazu",2000));
        reservasCacho.add(new ReservaComida("Desayuno",1000));
        reservasCacho.add(new ReservaBoletoViaje("AerolineasArg",1200));
        reservasCacho.add(new ReservaBoletoTransporte("Auto",800));

        repoLocalizadores.add(cacho,reservasCacho);
        repoLocalizadores.add(cacho,reservasCacho);
        System.out.println(repoLocalizadores);

    }
}