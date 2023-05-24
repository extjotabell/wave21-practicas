import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear clientes, el 2 no lo ocupo asi que un poquito de tranpita
        Cliente cliente1 = new Cliente("Cliente1");
        Cliente cliente2 = new Cliente("Cliente2");

        // Crear localizador con paquete completo para cliente1
        List<Reserva> reservas1 = new ArrayList<>();
        reservas1.add(new ReservaHotel("Hotel1"));
        reservas1.add(new ReservaComida("Comida1"));
        reservas1.add(new BoletoViaje("Boleto1"));
        reservas1.add(new Transporte("Transporte1"));
        Localizador localizador1 = new Localizador(cliente1, 1000, reservas1);

        // Imprimir resultado del localizador
        System.out.println(localizador1);

        // Agregar localizador a cliente1
        cliente1.agregarLocalizador(localizador1);

        // Crear localizador con 2 reservas de hotel y 2 de boletos para cliente1
        List<Reserva> reservas2 = new ArrayList<>();
        reservas2.add(new ReservaHotel("Hotel2"));
        reservas2.add(new ReservaHotel("Hotel3"));
        reservas2.add(new BoletoViaje("Boleto2"));
        reservas2.add(new BoletoViaje("Boleto3"));
        Localizador localizador2 = new Localizador(cliente1, 2000, reservas2);

        // Imprimir resultado del localizador
        System.out.println(localizador2);

        // Agregar localizador a cliente1
        cliente1.agregarLocalizador(localizador2);

        // Crear localizador con una sola reserva para cliente1
        List<Reserva> reservas3 = new ArrayList<>();
        reservas3.add(new ReservaHotel("Hotel4"));
        Localizador localizador3 = new Localizador(cliente1, 500, reservas3);

        // Imprimir resultado del localizador
        System.out.println(localizador3);

        // Agregar localizador a cliente1
        cliente1.agregarLocalizador(localizador3);

        // Verificar descuentos
        if (cliente1.haRealizadoComprasAnteriores()) {
            System.out.println(cliente1.getNombre() + " tiene descuento del 5% para futuras compras.");
        }

        if (cliente1.haAdquiridoPaqueteCompleto()) {
            System.out.println(cliente1.getNombre() + " tiene descuento del 10% por adquirir paquete completo.");
        }

        if (cliente1.haAdquiridoReservasHotel()) {
            System.out.println(cliente1.getNombre() + " tiene descuento del 5% en reservas de hotel.");
        }

        if (cliente1.haAdquiridoBoletosViaje()) {
            System.out.println(cliente1.getNombre() + " tiene descuento del 5% en boletos de viaje.");
        }
    }
}