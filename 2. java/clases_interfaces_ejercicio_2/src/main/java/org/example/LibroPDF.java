package org.example;

import javax.print.Doc;

public class LibroPDF extends Documento implements Imprimir {

    int cantidadDePaginas;
    String nombreAutor;
    String titulo;
    String genero;

    public LibroPDF(int cantidadDePaginas, String nombreAutor, String titulo, String genero) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    public int getCantidadDePaginas() {
        return cantidadDePaginas;
    }

    public void setCantidadDePaginas(int cantidadDePaginas) {
        this.cantidadDePaginas = cantidadDePaginas;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
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

    @Override
    public void tipoDocumento() {
        System.out.println("Soy un " + getClass().getName());
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo contenido: " + "Genero = " + getGenero() + ", Titulo = " + getTitulo() + ", Nombre del Autor = " + getNombreAutor() + ", Cantidad de Paginas = " + getCantidadDePaginas());
    }
}
