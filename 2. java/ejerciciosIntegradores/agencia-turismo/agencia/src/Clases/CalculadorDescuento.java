package Clases;

import java.util.Map;
import java.util.stream.Collectors;

public class CalculadorDescuento implements Interfaces.CalculadorDescuento {
    @Override
    public double calcularDescuento(Cliente cliente, Localizador localizador) {
        double descuento = 0.0;
        RepositorioLocalizador repositorioLocalizador = new RepositorioLocalizador();

        // Si un cliente anteriormente adquirió al menos 2 localizadores,
        // se le descontará un 5% del total para futuras compras.
        System.out.println(repositorioLocalizador.contarPorClienteId(cliente.getId()));
        if (repositorioLocalizador.contarPorClienteId(cliente.getId()) >= 2){
           descuento += 0.05;
        }

        // Si un cliente adquiere un paquete completo que consiste en reserva de hotel, comida, boletos de viajes, transporte, recibirá un descuento del 10% del total de la factura.
        long count = localizador.getReservas().stream()
                .map(Reserva::getTipo)
                .distinct()
                .count();
        if (count == 4) { // asumimos que hay 4 tipos de reserva
            descuento += 0.10;
        }
        // Si un cliente adquiere 2 reservas de hotel o 2 boletos de viaje, se aplicará un descuento de 5% en esas reservas.
        Map<String, Long> countByType = localizador.getReservas().stream()
                .collect(Collectors.groupingBy(Reserva::getTipo, Collectors.counting()));
        if (countByType.get("hotel") >= 2 || countByType.get("viaje") >= 2) {
            descuento += 0.05;
        }

        return descuento;
    }
}
