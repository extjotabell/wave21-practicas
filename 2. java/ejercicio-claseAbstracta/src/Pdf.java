public class Pdf implements Imprimible{
    private int cantidadPaginas;
    private String autor;
    private String titulo;
    private String genero;

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
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

    public Pdf() {

    }

    public Pdf(int cantidadPaginas, String autor) {
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
    }

    public void toOneString(){
        System.out.println("ACA IMPRIMO UN PDF");
    }
    @Override
    public void imprimir(){
        this.toOneString();
    }}
