public class Informe implements Documento{
    private String texto;
    private int cantidadPaginas;
    private Persona autor;
    private Persona revisor;

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

    public Persona getAutor() {
        return autor;
    }

    public void setAutor(Persona autor) {
        this.autor = autor;
    }

    public Persona getRevisor() {
        return revisor;
    }

    public void setRevisor(Persona revisor) {
        this.revisor = revisor;
    }

    public Informe(String texto, int cantidadPaginas, Persona autor, Persona revisor) {
        this.texto = texto;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String imprimir() {
        return "Autor: " + autor.toString() + " Revisor: " + revisor.toString() + " Cantidad Paginas: " +
                cantidadPaginas + " Texto: " + texto;
    }
}
