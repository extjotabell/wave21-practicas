package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // paquete turistico = reserva de (hotel, comida, boletos de viajes, transporte)
        // localizador = reservas( datos cliente, total, reserva)
        // repositorio = localizador

        //Creo los clientes
        Cliente cliente1 = new Cliente(11111111, "Pepe", "Garcia");
        Cliente cliente2 = new Cliente(11111112, "Pedro", "Rodriguez");
        Cliente cliente3 = new Cliente(11111113, "Pablo", "Gonzalez");

        //Creo una lista de clientes
        List<Cliente> clienteList = new ArrayList<Cliente>();

        //Agrego los clientes a una lista
        clienteList.add(cliente1);
        clienteList.add(cliente2);
        clienteList.add(cliente3);

        //Creo los paquetes turisticos
        PaqueteTuristico paqueteTuristico1 = new PaqueteTuristico(1, 1, 1, 1);
        PaqueteTuristico paqueteTuristico2 = new PaqueteTuristico(2, 0, 2 ,0);
        PaqueteTuristico paqueteTuristico3 = new PaqueteTuristico(1, 0, 0, 0);

        //Creo el localizador
        Localizador localizador1 = new Localizador(cliente1, 4000, paqueteTuristico1);
        Localizador localizador2 = new Localizador(cliente1, 4000, paqueteTuristico2);
        Localizador localizador3 = new Localizador(cliente2, 1000, paqueteTuristico3);

        //Agrego el localizador a una lista
        List<Localizador> localizadorList = new ArrayList<Localizador>();

        localizadorList.add(localizador1);
        localizadorList.add(localizador2);
        localizadorList.add(localizador3);

        System.out.println("");
        System.out.println("Lista de Localizadores");
        System.out.println("");
        for (Localizador localizador: localizadorList) {
            System.out.println(localizador);
        }

        Map<Object, Long> localizadorCuenta = localizadorList.stream()
                .collect(Collectors.groupingBy(n -> n.getCliente().dni, Collectors.counting()));

        System.out.println("");
        System.out.println("Cuenta de Localizadores por DNI");
        System.out.println("");
        System.out.println(localizadorCuenta);

        for (Localizador localizador: localizadorList) {

            System.out.println("");
            System.out.println("Reserva por Cliente");
            System.out.println(localizador.getReserva());
            System.out.println("");

            if (
                        localizador.getReserva().hotel == 1
                    &&
                        localizador.getReserva().boletosDeViajes == 1
                    &&
                        localizador.getReserva().comida == 1
                    &&
                        localizador.getReserva().transporte == 1
            ) {
                    int descuentoAplicado = 0;
                    int total = 0;

                    System.out.println("Descuento");
                    total = localizador.getTotal();
                    descuentoAplicado = total - ((total * 10) / 100);
                    System.out.println(descuentoAplicado);
                    localizador.setTotal(descuentoAplicado);
            } else if (
                        localizador.getReserva().boletosDeViajes == 2
                    &&
                        localizador.getReserva().hotel == 2
            ) {
                int descuentoAplicado = 0;
                int total = 0;

                System.out.println("Descuento");
                total = localizador.getTotal();
                descuentoAplicado = total - ((total * 5) / 100);
                System.out.println(descuentoAplicado);
                localizador.setTotal(descuentoAplicado);
            } else {
                for (Map.Entry e : localizadorCuenta.entrySet()) {

                    Long dniKey = (Long) e.getKey();
                    Long dniValue = (Long) e.getValue();

                    int descuentoAplicado = 0;
                    int total = 0;

                    System.out.println("DNI: " + dniKey + ", cuenta: " + dniValue);

                    if (dniValue >= 2 && localizador.getCliente().dni == dniKey) {
                        System.out.println("Descuento");
                        total = localizador.getTotal();
                        descuentoAplicado = total - ((total * 10) / 100);
                        System.out.println(descuentoAplicado);
                        localizador.setTotal(descuentoAplicado);
                    }
                }
            }


        }

        System.out.println("");
        System.out.println("Lista de Localizadores con descuento aplicado");
        System.out.println("");
        for (Localizador localizador: localizadorList) {
            System.out.println(localizador);
        }
    }
}