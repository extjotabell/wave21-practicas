package org.example;

import java.util.List;
public class Curriculum implements Imprimible {
  private String nombre;
  private String apellido;
  private String email;
  private List<Habilidades> habilidades;

  public Curriculum(String nombre, String apellido, String email, List<Habilidades> habilidades) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.email = email;
    this.habilidades = habilidades;
  }
  @Override
  public void imprimir() {

    System.out.printf(
      "Curriculum de %s. Habilidades %s\n",
      this.nombre,
      this.parseHabilidades()
    );
  }

  private String parseHabilidades() {
    return this.habilidades.toString();
  }
}
