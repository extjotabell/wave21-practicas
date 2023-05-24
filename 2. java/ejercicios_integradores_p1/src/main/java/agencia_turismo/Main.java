package agencia_turismo;

public class Main {
    public static void main(String[] args) {
        Repositorio<Cliente> repositorioCliente = new Repositorio<>();
        Cliente clientePrueba = new Cliente(0,"Juan", "Pérez", 24, "234456");
        int clienteId = repositorioCliente.agregarElemento(clientePrueba);

        Cliente clienteEnRepo = repositorioCliente.obtenerUnElemento(clienteId);

        Repositorio<Localizador> repositorioLocalizadores = new Repositorio<>();
        Localizador paqueteCompleto = new Localizador(clienteEnRepo.getId());

        ReservaComida reservaComida = new ReservaComida(129);
        ReservaHotel reservaHotel = new ReservaHotel(250);
        ReservaVuelo reservaVuelo = new ReservaVuelo(400);
        ReservaTransporte reservaTransporte = new ReservaTransporte(120);

        paqueteCompleto.agregarReserva(reservaComida);
        paqueteCompleto.agregarReserva(reservaHotel);
        paqueteCompleto.agregarReserva(reservaVuelo);
        paqueteCompleto.agregarReserva(reservaTransporte);

        repositorioLocalizadores.agregarElemento(paqueteCompleto);


    }
}
