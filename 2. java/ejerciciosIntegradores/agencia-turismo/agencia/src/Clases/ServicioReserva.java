package Clases;

import java.util.List;

public class ServicioReserva {
    private RepositorioCliente repositorioCliente;
    private RepositorioLocalizador repositorioLocalizador;
    private CalculadorDescuento calculadorDescuento;

    public ServicioReserva(RepositorioCliente repositorioCliente, RepositorioLocalizador repositorioLocalizador, CalculadorDescuento calculadorDescuento) {
        this.repositorioCliente = repositorioCliente;
        this.repositorioLocalizador = repositorioLocalizador;
        this.calculadorDescuento = calculadorDescuento;
    }

    public void crearReserva(Cliente cliente, List<Reserva> reservas) {
        // Crear un nuevo Localizador
        Localizador localizador = new Localizador();

        List<Localizador> localizadores = repositorioLocalizador.obtenerTodos();
        if (localizadores.size() != 0){
            Localizador ultimoLocalizador = localizadores.get(localizadores.size() - 1);

            double id = Double.parseDouble(ultimoLocalizador.getId()) + 1;
            localizador.setId(String.format("%.0f", id));
        }else{
            localizador.setId("1");
        }
        localizador.setCliente(cliente);
        localizador.setReservas(reservas);

        // Calcular el total
        double total = reservas.stream()
                .mapToDouble(Reserva::getCosto)
                .sum();

        // Calcular el descuento
        double descuento = calculadorDescuento.calcularDescuento(cliente, localizador);

        // Aplicar el descuento al total
        total -= total * descuento;

        // Establecer el total en el Localizador
        localizador.setTotal(total);

        // Agregar el Localizador al RepositorioLocalizador
        repositorioLocalizador.agregar(localizador);

        // Agregar el Localizador al Cliente y actualizar el Cliente en RepositorioCliente
        //cliente.getLocalizadores().add(localizador);
        repositorioCliente.agregar(cliente);
    }

    public void imprimirLocalizador(String idLocalizador) {
        // Buscar el Localizador en RepositorioLocalizador
        Localizador localizador = repositorioLocalizador.buscarPorId(idLocalizador);

        // Imprimir los detalles del Localizador
        System.out.println("\nLocalizador ID: " + localizador.getId());
        System.out.println("Cliente ID: " + localizador.getCliente().getId());
        System.out.println("Total: " + localizador.getTotal());
        System.out.println("Reservas:");
        for (Reserva reserva : localizador.getReservas()) {
            System.out.println("- " + reserva.getId() + ": " + reserva.getTipo() + ", " + reserva.getCosto());
        }
    }
}
