package org.example;

public class Pdf implements Imprimible {
  private int cantidadPaginas;
  private String autor;
  private String titulo;
  private String genero;

  public Pdf(int paginas, String autor, String titulo, String genero) {
    this.cantidadPaginas = paginas;
    this.autor = autor;
    this.titulo = titulo;
    this.genero = genero;
  }

  @Override
  public void imprimir() {
    System.out.printf(
      "%s fue escrito por %s. El genero es %s y tiene %s paginas\n",
      this.titulo,
      this.autor,
      this.genero,
      this.cantidadPaginas
    );
  }
}
