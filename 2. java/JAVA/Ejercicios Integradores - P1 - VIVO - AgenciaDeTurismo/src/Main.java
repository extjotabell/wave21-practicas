import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Se crean diferentes reservas.
        Reserva hotel1 = new ReservaHotel("Hotel 1", 20);
        Reserva comida1 = new ReservaComida("Comida 1", 45);
        Reserva boleto1 = new ReservaBoletosDeViaje("Boleto 1", 5);
        Reserva transporte1 = new ReservaTransporte("Transport1", 10);
        Reserva hotel2 = new ReservaHotel("Hotel 2", 20);
        Reserva comida2 = new ReservaComida("Comida 2", 45);
        Reserva boleto2 = new ReservaBoletosDeViaje("Boleto 2", 5);
        Reserva transporte2 = new ReservaTransporte("Transport2", 10);


        //Creo clientes, repositorio de clientes y se agregan.
        Cliente cli1 = new Cliente("Marcelo", 1234567L);
        Cliente cli2 = new Cliente("Javier", 7654321L);
        RepositorioCliente repoCliente = new RepositorioCliente();
        repoCliente.agregarAlRepositorio(cli1);
        repoCliente.agregarAlRepositorio(cli2);

        //Se crean Localizadores con distintas reservas.
        Localizador localizador1 = new Localizador(cli1);
        localizador1.agregarReserva(hotel1);
        localizador1.agregarReserva(comida1);
        localizador1.agregarReserva(boleto1);
        localizador1.agregarReserva(transporte1);
        localizador1.total();

        Localizador localizador2 = new Localizador(cli1);
        localizador2.agregarReserva(hotel1);
        localizador2.agregarReserva(hotel2);
        localizador2.agregarReserva(boleto1);
        localizador2.agregarReserva(boleto2);
        localizador2.total();

        Localizador localizador3 = new Localizador(cli1);
        localizador3.agregarReserva(transporte2);
        localizador3.total();

        Localizador localizador4 = new Localizador(cli2);
        localizador4.agregarReserva(hotel2);
        localizador4.agregarReserva(boleto1);
        localizador4.agregarReserva(boleto2);
        localizador4.total();

        //Se crea un repositorio de localizadores y se agregan localizadores a su lista.
        RepositorioLocalizador repoLocalizadores = new RepositorioLocalizador();
        repoLocalizadores.agregarAlRepositorio(localizador1);
        repoLocalizadores.agregarAlRepositorio(localizador2);
        repoLocalizadores.agregarAlRepositorio(localizador3);

        //Se aplican los descuentos que correspondientes a cada Localizador del repositorio
        repoLocalizadores.aplicarDescuentos();

    }
}

