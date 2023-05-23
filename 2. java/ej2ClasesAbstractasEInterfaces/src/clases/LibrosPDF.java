package clases;

import interfaces.Imprimir;

public class LibrosPDF implements Imprimir {
    private int cantidadDePaginas;
    private String nombre;
    private String titulo;
    private String genero;

    public LibrosPDF(int cantidadDePaginas, String nombre, String titulo, String genero) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.nombre = nombre;
        this.titulo = titulo;
        this.genero = genero;
    }

    public int getCantidadDePaginas() {
        return cantidadDePaginas;
    }

    public void setCantidadDePaginas(int cantidadDePaginas) {
        this.cantidadDePaginas = cantidadDePaginas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    public void imprimir() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "LibrosPDF{" +
                "cantidadDePaginas=" + cantidadDePaginas +
                ", nombre='" + nombre + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
