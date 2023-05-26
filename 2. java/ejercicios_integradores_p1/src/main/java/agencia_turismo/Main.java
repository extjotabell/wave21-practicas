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

        System.out.println("Primer Localizador:");
        int idLocalizador = agregarPrimerLocalizador(clienteEnRepo);
        Localizador primerLocalizador = repositorioLocalizadores.getElemento(idLocalizador);
        System.out.println("Unico descuento aplicado es por ser paquete completo 10%");
        System.out.printf("%s%.2f%n", "Costo total solo con paquete completo es: ", primerLocalizador.getCostoConDescuentosAplicados());
        verificarResultado(primerLocalizador, 809.10);
        clienteEnRepo.agregarLocalizador(primerLocalizador);

        System.out.println();
        System.out.println("Segundo Localizador:");
        idLocalizador = agregarSegundoLocalizador(clienteEnRepo);
        Localizador segundoLocalizador = repositorioLocalizadores.getElemento(idLocalizador);
        System.out.println("Aplica descuento 5% a cada una de las 4 reservas");
        System.out.printf("%s%.2f%n", "Costo total con reservas de vuelos y hotel es: ", segundoLocalizador.getCostoConDescuentosAplicados());
        verificarResultado(segundoLocalizador, 646.00);
        clienteEnRepo.agregarLocalizador(segundoLocalizador);

        System.out.println();
        System.out.println("Tercer Localizador:");
        idLocalizador = agregarTercerLocalizador(clienteEnRepo);
        Localizador tercerLocalizador = repositorioLocalizadores.getElemento(idLocalizador);
        clienteEnRepo.agregarLocalizador(tercerLocalizador);

        System.out.println("Aplica descuento 5% por tener 2 localizadores previos");
        System.out.printf("%s%.2f%n", "Costo total es: ", tercerLocalizador.getCostoConDescuentosAplicados());
        verificarResultado(tercerLocalizador, 45.00);
    }

    private static int agregarClienteDeEjemploARepo() {
        Cliente clientePrueba = new Cliente(0, "Juan", "Pérez", 24, "234456");
        return repositorioClientes.agregarElemento(clientePrueba);
    }

    private static int agregarPrimerLocalizador(Cliente cliente) {
        Localizador paqueteCompleto = new Localizador(cliente);
        ReservaComida reservaComida = new ReservaComida(129);
        ReservaHotel reservaHotel = new ReservaHotel(250);
        ReservaVuelo reservaVuelo = new ReservaVuelo(400);
        ReservaTransporte reservaTransporte = new ReservaTransporte(120);
        List<Reserva> reservas = List.of(
                reservaComida,
                reservaHotel,
                reservaVuelo,
                reservaTransporte
        );
        paqueteCompleto.agregarMultiplesReservas(reservas);
        System.out.println("Costo sin descuento: " + reservas.stream().mapToDouble(Reserva::getCosto).sum());
        return repositorioLocalizadores.agregarElemento(paqueteCompleto);
    }

    private static int agregarSegundoLocalizador(Cliente cliente) {
        ReservaHotel reservaHotel1 = new ReservaHotel(200);
        ReservaHotel reservaHotel2 = new ReservaHotel(220);

        ReservaVuelo reservaVuelo1 = new ReservaVuelo(140);
        ReservaVuelo reservaVuelo2 = new ReservaVuelo(120);

        Localizador nuevasReservas = new Localizador(cliente);
        List<Reserva> reservas = List.of(reservaHotel1, reservaHotel2, reservaVuelo1, reservaVuelo2);
        nuevasReservas.agregarMultiplesReservas(reservas);
        System.out.println("Costo sin descuento: " + reservas.stream().mapToDouble(Reserva::getCosto).sum());
        return repositorioLocalizadores.agregarElemento(nuevasReservas);
    }

    private static int agregarTercerLocalizador(Cliente cliente) {
        Localizador tercerLocalizador = new Localizador(cliente);
        ReservaComida reservaComida = new ReservaComida(50);
        tercerLocalizador.agregarReserva(reservaComida);
        System.out.println("Costo sin descuento: " + reservaComida.getCosto());
        return repositorioLocalizadores.agregarElemento(tercerLocalizador);
    }
    private static void verificarResultado(Localizador localizador, double costoEsperado){
        System.out.println("Verificación de resultado para localizador de id: " + localizador.getId());
        if (localizador.getCostoConDescuentosAplicados() == costoEsperado){
            System.out.println("Se esperaba " + costoEsperado + " y se obtuvo correctamente " + localizador.getCostoConDescuentosAplicados());
        }else {
            System.out.println("Se esperaba " + costoEsperado + " y se obtuvo incorrectamente " + localizador.getCostoConDescuentosAplicados());
        }
    }
    private static void ejectuarParte2() {
        System.out.println();
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
