package com.bootcamp.wave21;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        /**INICIALIZO TODAS LAS VARIABLES***/
        GestorCliente gestor = new GestorCliente(new RepositorioCliente(), new RepositorioLocalizador());

        Cliente cliente1 = new Cliente("Juan Manuel", "33");
        Cliente cliente2 = new Cliente("Pedro Ernesto", "44");
        Localizador localizador1 = new Localizador();
        localizador1.setCliente(cliente1);
        localizador1.agregarReserva(new ReservaComida(100));
        localizador1.aplicarMontoTotal();
        Localizador localizador2 = new Localizador();
        localizador2.setCliente(cliente2);
        localizador2.agregarReserva(new ReservaHotel(300));
        localizador2.aplicarMontoTotal();
        Localizador localizador3 = new Localizador();
        localizador3.setCliente(cliente1);
        localizador3.agregarReserva(new ReservaComida(300));
        localizador3.aplicarMontoTotal();
        gestor.getRepoCliente().agregarCliente(cliente1);
        gestor.getRepoLoca().agregarLocalizador(localizador1);
        gestor.getRepoCliente().agregarCliente(cliente2);
        gestor.getRepoLoca().agregarLocalizador(localizador2);
        gestor.getRepoLoca().agregarLocalizador(localizador3);

        System.out.println("*****MUESTRO ESCENARIO INICIAL*******");

        for (HashMap.Entry<String, Cliente> cliente : gestor.getRepoCliente().getClientes().entrySet()) {
            for (Localizador loc : gestor.buscarLocalizadoresPorCliente(cliente.getValue().getDni())) {
                System.out.println(loc.toString());
            }
        }
        System.out.println("*****CLIENTE 1 CREA NUEVAS RESERVAS - COMPLETO*******");
        Localizador completo = new Localizador();
        completo.agregarReserva(new ReservaComida(200));
        completo.agregarReserva(new ReservaHotel(1000));
        completo.agregarReserva(new ReservaVuelo(3000));
        completo.agregarReserva(new ReservaTransporte(800));
        completo.setCliente(cliente1);
        completo.aplicarMontoTotal();

        System.out.println("Se muestra antes de aplicar descuentos");
        System.out.println(completo.toString());
        System.out.println("Ahora aplicamos descuentos");
        completo.aplicarDescuentos(gestor);
        System.out.println("Se muestra con el descuento aplicado");
        System.out.println(completo.toString());
        gestor.getRepoLoca().agregarLocalizador(completo);
        System.out.println("Ahora creo uno con 3 hoteles y veo si aplica descuento");
        Localizador conTresHoteles = new Localizador();
        conTresHoteles.setCliente(cliente2);
        conTresHoteles.agregarReserva(new ReservaHotel(50000));
        conTresHoteles.agregarReserva(new ReservaHotel(25000));
        conTresHoteles.agregarReserva(new ReservaHotel(25000));
        conTresHoteles.aplicarMontoTotal();
        System.out.println(conTresHoteles.toString());
        System.out.println("Se muestra con el descuento aplicado");
        conTresHoteles.aplicarDescuentos(gestor);
        System.out.println(conTresHoteles.toString());
        gestor.getRepoLoca().agregarLocalizador(conTresHoteles);

        System.out.println("\n\n *******MUESTRO TOTALIZADORES*******");
        System.out.println("CANTIDAD DE LOCALIZADORES VENDIDOS");
        System.out.println(gestor.cantidadLocalizadoresVendidos());
        System.out.println("CANTIDAD DE RESERVAS REALIZADAS ");
        System.out.println(gestor.cantidadTotalDeReservas());
        System.out.println("TOTAL VENTAS  REALIZADAS ");
        System.out.println(gestor.totalVentas());

    }

}
