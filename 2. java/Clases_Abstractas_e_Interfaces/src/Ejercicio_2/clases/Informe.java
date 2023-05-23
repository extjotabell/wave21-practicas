package Ejercicio_2.clases;

import Ejercicio_2.interfaces.Imprimible;

public class Informe implements Imprimible {
    private String texto;
    private int cantPaginas;
    private String autor;
    private String revisor;

    public Informe(String texto, int cantPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println(String.format("Cantidad de Paginas: %d\nAutor: %s\nRevisor: %s\nTexto: %s", this.getCantPaginas(), this.getAutor(), this.getRevisor(), this.getTexto()));
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }
}
