package org.example;

public class Informe extends Documento implements Imprimir {

    String texto;
    int cantidadDePaginas;
    String autor;
    String revisor;

    public Informe(String texto, int cantidadDePaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getCantidadDePaginas() {
        return cantidadDePaginas;
    }

    public void setCantidadDePaginas(int cantidadDePaginas) {
        this.cantidadDePaginas = cantidadDePaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    @Override
    public void tipoDocumento() {
        System.out.println("Soy un " + getClass().getName());
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo contenido: " + "Autor = " + getAutor() + ", Texto = " + getTexto() + ", Cantidad de Paginas = " + getCantidadDePaginas() + ", Revisor = " + getRevisor() );
    }
}
