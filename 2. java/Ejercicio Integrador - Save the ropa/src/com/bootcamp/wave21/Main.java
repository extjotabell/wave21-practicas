package com.bootcamp.wave21;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	GuardaRopa guardaRopa = new GuardaRopa();
	Remera remera = new Remera("Nike","Air");
	Campera campera = new Campera("Samcro","3XWM");
    List<Prenda> prendas = new ArrayList<Prenda>();
    prendas.add(remera);
    prendas.add(campera);
    int ticket;
    System.out.println("Guardando ropa.....");
    ticket = guardaRopa.guardarPrenda(prendas);
    System.out.println("El numero asignado es :  " + ticket);
    System.out.println("Pruebo consultar con un identificador falso 9999");
    guardaRopa.mostrarPrendasPorNumero(9999);
    System.out.println("Ahora consultamos por lo guardado bajo el ticket ");
    guardaRopa.mostrarPrendasPorNumero(ticket);

    }
}
