package Ejercicio2;

public class LibroEnPDF implements  Imprimible{
    public int cantidadDePaginas;
    public String autor;
    public String titulo;
    public String genero;

    @Override
    public void imprimir() {
        System.out.println("\nCantidad de Paginas: " + this.cantidadDePaginas + "\nAutor: " + this.autor + "\nTitulo: " + this.titulo + "\nGenero: " + this.genero);
    }

    //Constructor, getters, setters
    public LibroEnPDF(int cantidadDePaginas, String autor, String titulo, String genero) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
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
