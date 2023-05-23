package org.example;

public class Informes implements Imprimible {
  String revisor;
  String autor;
  String texto;
  int cantidadPaginas;

  public Informes(String revisor, String autor, String texto, int cantidadPaginas) {
    this.revisor = revisor;
    this.autor = autor;
    this.texto = texto;
    this.cantidadPaginas = cantidadPaginas;
  }

  @Override
  public void imprimir() {
    System.out.printf("informe: %s\n", this.autor);
  }
}
