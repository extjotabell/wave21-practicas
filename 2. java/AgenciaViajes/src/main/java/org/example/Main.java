package org.example;

import org.example.repositorios.ClienteRepositorio;
import org.example.repositorios.LocalizadorRepositorio;
import org.example.reservas.*;

import java.util.*;

public class Main {
  static final LocalizadorRepositorio localizadores = new LocalizadorRepositorio();

  public static void main(String[] args) {
    Clientes c = new Clientes("Nahuel", 11111111);
    ClienteRepositorio.add(c);

    Localizador lCompleto = Main.createLocalizador(
      c,
      new BoletosReserva("boletos", 100d),
      new HotelReserva("hotel", 100d),
      new ComidaReserva("comida", 100d),
      new TransporteReserva("transporte", 100d)
    );

    /*
    Localizador l1 = Main.createLocalizador(
      c,
      new BoletosReserva("boletos", 100d)
    );
     */

    /*Localizador l2 = Main.createLocalizador(
      c,
      new BoletosReserva("boletos", 100d),
      new TransporteReserva("transporte", 100d)
    );
     */

    ClienteRepositorio.add(c);

    Clientes toSearch = c;

    try {
      List<Localizador> localizadores = LocalizadorRepositorio.searchByClient(toSearch);
      localizadores.forEach(l -> l.descuentos(localizadores.size()));
      localizadores.forEach(System.out::println);
    } catch(IllegalArgumentException e) {
      System.out.println("No se encontro el cliente");
      ClienteRepositorio.add(c);
    }
  }

  static public Localizador createLocalizador(Clientes c, Reservas ...reservas) {

    Localizador localizador = new Localizador(c);

    Arrays.stream(reservas).forEach(localizador::addReserva);

    Main.localizadores.add(localizador);
    return localizador;
  }
}