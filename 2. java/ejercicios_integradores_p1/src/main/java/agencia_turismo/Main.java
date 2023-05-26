package agencia_turismo;

import agencia_turismo.parte2.ConsultorDeLocalizadores;

import java.util.List;
import java.util.Map;

public class Main {
    private static Repositorio<Localizador> repositorioLocalizadores;
    private static Repositorio<Cliente> repositorioClientes;

    public static void main(String[] args) {
        repositorioClientes = new Repositorio<>();
        repositorioLocalizadores = new Repositorio<>();

        ejecutarParte1();
        ejectuarParte2();
    }

    private static void ejecutarParte1() {
        int idCliente = agregarClienteDeEjemploARepo();
        Cliente clienteEnRepo = repositorioClientes.getElemento(idCliente);

        int idLocalizador = agregarPrimerLocalizador(idCliente);
        Localizador primerLocalizador = repositorioLocalizadores.getElemento(idLocalizador);
        System.out.println("Unico descuento aplicado es por ser paquete completo 10%");
        System.out.printf("%s%.2f%n", "Costo total solo con paquete completo es: ", primerLocalizador.getCostoConDescuentosDeLocalizadorAplicados());
        clienteEnRepo.agregarLocalizador(primerLocalizador);

        idLocalizador = agregarSegundoLocalizador(idCliente);
        Localizador segundoLocalizadorDesdeRepositorio = repositorioLocalizadores.getElemento(idLocalizador);
        System.out.println("Aplica descuento 5% a cada una de las 4 reservas");
        System.out.printf("%s%.2f%n", "Costo total con reservas de vuelos y hotel es: ", segundoLocalizadorDesdeRepositorio.getCostoConDescuentosDeLocalizadorAplicados());
        clienteEnRepo.agregarLocalizador(segundoLocalizadorDesdeRepositorio);

        idLocalizador = agregarTercerLocalizador(idCliente);
        Localizador tercerLocalizador = repositorioLocalizadores.getElemento(idLocalizador);
        clienteEnRepo.agregarLocalizador(tercerLocalizador);

        System.out.println("Aplica descuento 5% por tener 2 localizadores previos");
        System.out.printf("%s%.2f%n", "Costo total es: ", tercerLocalizador.getCostoConDescuentosDeLocalizadorAplicados());
    }

    private static int agregarClienteDeEjemploARepo() {
        Cliente clientePrueba = new Cliente(0, "Juan", "Pérez", 24, "234456");
        return repositorioClientes.agregarElemento(clientePrueba);
    }

    private static int agregarPrimerLocalizador(int idCliente) {
        Localizador paqueteCompleto = new Localizador(idCliente);
        ReservaComida reservaComida = new ReservaComida(129);
        ReservaHotel reservaHotel = new ReservaHotel(250);
        ReservaVuelo reservaVuelo = new ReservaVuelo(400);
        ReservaTransporte reservaTransporte = new ReservaTransporte(120);
        paqueteCompleto.agregarMultiplesReservas(List.of(
                        reservaComida,
                        reservaHotel,
                        reservaVuelo,
                        reservaTransporte
                )
        );
        return repositorioLocalizadores.agregarElemento(paqueteCompleto);
    }

    private static int agregarSegundoLocalizador(int idCliente) {
        ReservaHotel reservaHotel1 = new ReservaHotel(200);
        ReservaHotel reservaHotel2 = new ReservaHotel(220);

        ReservaVuelo reservaVuelo1 = new ReservaVuelo(140);
        ReservaVuelo reservaVuelo2 = new ReservaVuelo(120);

        Localizador nuevasReservas = new Localizador(idCliente);
        nuevasReservas.agregarMultiplesReservas(List.of(reservaHotel1, reservaHotel2, reservaVuelo1, reservaVuelo2));

        return repositorioLocalizadores.agregarElemento(nuevasReservas);
    }

    private static int agregarTercerLocalizador(int idCliente) {
        Localizador tercerLocalizador = new Localizador(idCliente);
        ReservaComida reservaComida1 = new ReservaComida(50);
        tercerLocalizador.agregarReserva(reservaComida1);
        return repositorioLocalizadores.agregarElemento(tercerLocalizador);
    }

    private static void ejectuarParte2() {
        ConsultorDeLocalizadores consultor = new ConsultorDeLocalizadores(repositorioLocalizadores);
        System.out.println("Ejecución parte 2, clase consultor de localizadores");
        consultor.mostrarLocalizadoresVendidos();
        consultor.mostrarReservasHechas();
        imprimirMapa(consultor.getReservasPorTipo());
        consultor.mostrarTotalDeLasVentas();
        consultor.mostrarPromedioDeLasVentas();
    }

    private static void imprimirMapa(Map<Class<? extends Reserva>, List<Reserva>> mapa) {
        mapa.forEach((tr, lr) -> {
            StringBuilder sb = new StringBuilder();
            sb.append("Tipo: ").append(tr.getSimpleName()).append("\n");
            sb.append("[ ");
            lr.forEach(x -> sb.append(x).append(", "));
            sb.replace(sb.length() -2, sb.length(), " ]\n");
            System.out.print(sb);
        });
    }
}
