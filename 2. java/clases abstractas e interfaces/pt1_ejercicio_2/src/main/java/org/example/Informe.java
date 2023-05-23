package org.example;

public class Informe implements Documento{
    private String texto;
    private int cantidadPaginas;
    private String autor;
    private String revisor;

    @Override
    public void imprimir() {
        System.out.println("Informe escrito por " + this.autor +" y revisado por " + this.revisor +"./n"+this.texto);
    }

    public Informe(String texto, int cantidadPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    public String getTexto() {
        return texto;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public String getRevisor() {
        return revisor;
    }
}
