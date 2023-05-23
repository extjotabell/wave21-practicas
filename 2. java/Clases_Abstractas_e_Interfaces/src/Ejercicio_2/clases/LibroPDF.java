package Ejercicio_2.clases;

import Ejercicio_2.interfaces.Imprimible;

public class LibroPDF implements Imprimible {
    private int cantPaginas;
    private String autor;
    private String titulo;
    private String genero;

    public LibroPDF(int cantPaginas, String autor, String titulo, String genero) {
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println(String.format("Cantidad de Paginas: %d\nAutor: %s\nTitulo: %s\nGenero: %s\n", this.getCantPaginas(), this.getAutor(), this.getTitulo(), this.getGenero()));
    }

    public int getCantPaginas() {
        return cantPaginas;
    }

    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
