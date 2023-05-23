package ejercicio_documentos;

public class LibroPdf implements  Imprimible{
    private int cantidadPaginas;
    private Persona autor;
    private String titulo;
    private String genero;

    public LibroPdf(int cantidadPaginas, Persona autor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println( "Este es un LibroPdf de " +
                 cantidadPaginas +
                " paginas, con autor " + autor.getNombre() +
                ", tiitulo '" + titulo + '\'' +
                " y genero '" + genero + '\'' );
    }
}
