package org.example.Ej2;

public class LibroPdf implements IImprimible{
    private int cantPag;
    private String titulo;
    private String autor;
    private String genero;

    public LibroPdf(int cantPag, String titulo, String autor, String genero) {
        this.cantPag = cantPag;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
    }

    public int getCantPag() {
        return cantPag;
    }

    public void setCantPag(int cantPag) {
        this.cantPag = cantPag;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "LibroPdf{" +
                "cantPag=" + cantPag +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println(toString());
    }
}
