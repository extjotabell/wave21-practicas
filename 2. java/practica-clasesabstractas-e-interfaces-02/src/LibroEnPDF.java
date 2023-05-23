public class LibroEnPDF implements Imprimible{

    int cantidadDeHojas;
    String nombreAutor;
    String titulo;
    String genero;

    public LibroEnPDF(int cantidadDeHojas, String nombreAutor, String titulo, String genero) {
        this.cantidadDeHojas = cantidadDeHojas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    public int getCantidadDeHojas() {
        return cantidadDeHojas;
    }

    public void setCantidadDeHojas(int cantidadDeHojas) {
        this.cantidadDeHojas = cantidadDeHojas;
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
    public void imprimir() {
        System.out.println("El libro "+ this.titulo + " fue escrito por "+ this.nombreAutor + ", posee " + this.cantidadDeHojas + " paginas y pertenece al genero "+ this.genero);
    }
}
