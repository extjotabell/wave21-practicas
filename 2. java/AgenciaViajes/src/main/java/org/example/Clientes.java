package org.example;

import org.example.repositorios.LocalizadorRepositorio;
import org.example.reservas.BoletosReserva;
import org.example.reservas.HotelReserva;
import org.example.reservas.Reservas;
import org.example.reservas.TransporteReserva;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Clientes {
  String nombre;
  int dni;

  public Clientes(String nombre, int dni) {
    this.nombre = nombre;
    this.dni = dni;
  }
}
