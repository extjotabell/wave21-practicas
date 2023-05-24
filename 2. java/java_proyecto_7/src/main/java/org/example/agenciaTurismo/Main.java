package org.example.agenciaTurismo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Juan");
        Reserva reserva1 = new Reserva("Hotel");
        Reserva reserva2 = new Reserva("Comida");
        Reserva reserva3 = new Reserva("Boleto");
        Reserva reserva4 = new Reserva("Transporte");
        List<Reserva> reservasCliente1 = new ArrayList<>(){{
            add(reserva1);
            add(reserva2);
            add(reserva3);
            add(reserva4);
        }};


        Localizador localizador1 = new Localizador(cliente1, reservasCliente1);
        Localizador localizador2 = new Localizador(cliente1, reservasCliente1);
        System.out.println(localizador2);
    }
}