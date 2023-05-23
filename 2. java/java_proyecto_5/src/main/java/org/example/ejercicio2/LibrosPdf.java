package org.example.ejercicio2;

public class LibrosPdf implements Documento{

    private int cantidadPaginas;
    private String autor;
    private String titulo;
    private String genero;

    @Override
    public void imprimir() {
        System.out.println("Titulo: "+ titulo + " Autor: " + autor + " - Genero: " + genero + " - Cantidad de paginas: " + cantidadPaginas);
    }

    public LibrosPdf(int cantidadPaginas, String autor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
