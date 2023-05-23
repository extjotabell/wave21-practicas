package org.Ejercicio2;

public class Informes implements Documento{
    private String texto;
    private int cantidadPaginas;
    private String nombreAutor;
    private String revisor;

    public Informes(String  texto, int cantidadPaginas, String nombreAutor, String revisor) {
        this.texto = texto;
        this.cantidadPaginas = cantidadPaginas;
        this.nombreAutor = nombreAutor;
        this.revisor = revisor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }
    @Override
    public void imprimir() {
        System.out.println("Informes{" +
                "texto='" + texto + '\'' +
                ", cantidadPaginas=" + cantidadPaginas +
                ", autor='" + nombreAutor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}');
    }
}
