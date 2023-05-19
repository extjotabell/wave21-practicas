package org.circuitos;

import org.example.Participante;

import java.util.HashMap;
import java.util.List;

public abstract class Circuito implements Pagable, Habilitable {
  int id;
  String nombre;
  String descripcion;
  List<Habilita> habilitados;

  public Circuito(int id, String nombre, String descripcion) {
    this.id = id;
    this.nombre = nombre;
    this.descripcion = descripcion;
  }

  public String getNombre() {
    return this.nombre;
  }

  public int getId() {
    return this.id;
  }
}
