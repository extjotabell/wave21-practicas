package org.circuitos;

import org.example.Participante;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Circuito  implements Pagable {
  int id;
  String nombre;
  String descripcion;
  List<Habilita> habilitados;

  public Circuito(int id, String nombre, String descripcion) {
    this.id = id;
    this.nombre = nombre;
    this.descripcion = descripcion;
  }

  public Map<Habilita, Float> monto() {
    return new HashMap<Habilita, Float>();
  }

  /**
   * Determina el monto a pagar por participante. Si no tiene un monto definido retorna 0f
   * @param p Participante
   * @return
   */
  public float habilita(Participante p) {
    return 0f;
  }

  public String getNombre(){
    return this.nombre;
  }

  public int getId() {
    return this.id;
  }
}
