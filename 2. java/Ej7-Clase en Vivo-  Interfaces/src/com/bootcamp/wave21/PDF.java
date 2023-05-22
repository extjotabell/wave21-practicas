package com.bootcamp.wave21;

public class PDF extends TipoDocumento  implements Imprimible {
    /*Incluyen atributos como cantidad de páginas, nombre del autor, título y género.*/
    private int cantidadDePaginas;
    private String nombreDelAutor;
    private String titulo;
    private String genero;

    public PDF() {
        this.titulo ="Sin titulo";
        this.nombreDelAutor = "Sin Nombre";
        this.genero = "Sin genero";
        this.cantidadDePaginas = 0;
    }

    public PDF(int cantidadDePaginas, String nombreDelAutor, String titulo, String genero) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.nombreDelAutor = nombreDelAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    public int getCantidadDePaginas() {
        return cantidadDePaginas;
    }

    public void setCantidadDePaginas(int cantidadDePaginas) {
        this.cantidadDePaginas = cantidadDePaginas;
    }

    public String getNombreDelAutor() {
        return nombreDelAutor;
    }

    public void setNombreDelAutor(String nombreDelAutor) {
        this.nombreDelAutor = nombreDelAutor;
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
        System.out.println(mostrarFormatoImprimible());
    }

    @Override
    public String toString() {
        return "PDF{" +
                "cantidadDePaginas=" + cantidadDePaginas +
                ", nombreDelAutor='" + nombreDelAutor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }

    public String mostrarFormatoImprimible(){
        return this.toString();
    }
}


