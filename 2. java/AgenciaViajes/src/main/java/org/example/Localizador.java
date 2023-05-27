package org.example;

import org.example.reservas.BoletosReserva;
import org.example.reservas.HotelReserva;
import org.example.reservas.Reservas;
import org.example.reservas.TransporteReserva;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
  private List<Reservas> reservas = new ArrayList<>();
  private Cliente cliente;

  private Double total;

  public Localizador(Cliente cliente) {
    this.cliente = cliente;
  }

  public void addReserva(Reservas r) {
    reservas.add(r);
  }
  public void setReservas(List<Reservas> r) {
    this.reservas = r;
  }

  public List<Reservas> getReservas() {
    return this.reservas;
  }

  public void setTotal(Double total) {
    this.total = total;
  }

  public void descuentos(int cantidadLocalizadores) {
    Double a = this.descuentoPaqueteFull();
    Double b = this.descuentoDosPaquetes(cantidadLocalizadores);
    Double c = this.descuentoPorHotelBoletos();

    Double descuento = Math.min(Math.min(a, b), c);

    if(descuento.equals(Double.MAX_VALUE))
      this.setTotal(this.reservas.stream().mapToDouble(Reservas::getMonto).sum());
    else
      this.setTotal(descuento);
  }

  private Double descuentoPaqueteFull() {

    Boolean hotel = this.reservas.stream().anyMatch(r -> r instanceof HotelReserva);
    Boolean boletos = this.reservas.stream().anyMatch(r -> r instanceof BoletosReserva);
    Boolean transporte = this.reservas.stream().anyMatch(r -> r instanceof TransporteReserva);

    if(hotel && boletos && transporte)
      return this.reservas.stream().mapToDouble(Reservas::getMonto).sum()*0.90;
    return Double.MAX_VALUE;
  }

  private Double descuentoDosPaquetes(int cantidadLocalizadores) {
    if(cantidadLocalizadores >= 2) {
      double total = this.reservas.stream().mapToDouble(Reservas::getMonto).sum();
      return total*0.95;
    }

    return Double.MAX_VALUE;
  }

  private Double descuentoPorHotelBoletos() {
    List<Reservas> reservasHotel = this.reservas.stream().filter(r -> r instanceof HotelReserva).toList();
    List<Reservas> reservasBoletos = this.reservas.stream().filter(r -> r instanceof BoletosReserva).toList();

    if(reservasHotel.size() >= 2)
      return reservasHotel.stream().map(Reservas::getMonto).mapToDouble(m -> m*0.95).sum();
    else if (reservasBoletos.size() >= 2)
      return reservasBoletos.stream().map(Reservas::getMonto).mapToDouble(m -> m*0.95).sum();

    return Double.MAX_VALUE;
  }

  public String toString() {
    String a = this.reservas.toString();
    return String.format("Total de la localizacion es: $%s. Con %s reservas. %s", this.total, this.reservas.size(), a);
  }

  public Cliente getCliente() {
    return this.cliente;
  }
}
