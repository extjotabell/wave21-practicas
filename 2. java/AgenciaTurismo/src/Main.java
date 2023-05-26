import java.util.ArrayList;
import java.util.Comparator;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ClienteRepositorio clienteRepositorio = new ClienteRepositorioImplementacion();
        Cliente cliente1 = new Cliente("123456789", "Pedro");
        Localizador localizador1 = new Localizador(cliente1);
        localizador1.nuevaReserva(new Hotel(30));
        localizador1.nuevaReserva(new Comida(10));
        localizador1.nuevaReserva(new VoletoViaje(25));
        localizador1.nuevaReserva(new Transporte(15));
        clienteRepositorio.agregarLocalizador(localizador1);
        localizador1.imprimir();

        Localizador localizador2 = new Localizador(cliente1);
        localizador2.nuevaReserva(new Hotel(45));
        localizador2.nuevaReserva(new Hotel(25));
        localizador2.nuevaReserva(new VoletoViaje(10));
        localizador2.nuevaReserva(new VoletoViaje(10));
        clienteRepositorio.agregarLocalizador(localizador2);
        localizador2.imprimir();

        Localizador localizador3 = new Localizador(cliente1);
        localizador3.nuevaReserva(new Hotel(200));
        clienteRepositorio.agregarLocalizador(localizador3);
        localizador3.imprimir();
        ArrayList<Reserva> reservas = new ArrayList<Reserva>();
        clienteRepositorio.getLocalizadores().forEach(localizador -> reservas.addAll(localizador.getReservas()));
        System.out.println(" ");
        System.out.println("Cantidad localizadore vendidos: " + clienteRepositorio.getLocalizadores().size());
        System.out.println(" ");
        System.out.println("Cantidad total reservas: " + reservas.size());
        System.out.println(" ");
        System.out.println("Reservas clasificadas por tipo:");
        reservas.stream().sorted(Comparator.comparing(Reserva::getNombre)).forEach(System.out::println);
        System.out.println("Promedio total ventas:" + reservas.stream().mapToDouble(Reserva::getPrecio).average().orElse(0));
    }
}