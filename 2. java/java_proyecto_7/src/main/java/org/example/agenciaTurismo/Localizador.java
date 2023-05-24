package org.example.agenciaTurismo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Localizador {
    private Cliente cliente;
    private double total;
    private List<Reserva> reservas;

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        cliente.addLocalizador();
        this.cliente = cliente;
        this.reservas = reservas;
        this.total = calcularCosto(reservas);
    }

    private double calcularCosto(List<Reserva> reservas) {
        double costoInicial = reservas.size() * 100;

        List<String> paqueteCompleto = Arrays.asList("Comida", "Boleto", "Transporte", "Hotel");

        boolean esCompleto = new HashSet<>(reservas.stream()
                .map(Reserva::getTipoReserva)
                .toList())
                .containsAll(paqueteCompleto);

        if (esCompleto) {
            costoInicial = costoInicial * 0.9;
        } else {
            boolean dosHoteles = reservas.stream()
                    .filter(reserva -> reserva.getTipoReserva().equals("Hotel"))
                    .count() == 2;

            boolean dosBoletos = reservas.stream()
                    .filter(reserva -> reserva.getTipoReserva().equals("Boleto"))
                    .count() == 2;

            if(dosHoteles || dosBoletos){
                costoInicial = costoInicial * 0.95;
            }

        }
        System.out.println(cliente.getCantidadLocalizadores());
        return (cliente.getCantidadLocalizadores() >= 2) ? costoInicial*0.95 : costoInicial;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", total=" + total +
                ", reservas=" + reservas +
                '}';
    }
}
