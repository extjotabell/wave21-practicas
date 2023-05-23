package Ejercicio2;

public class Informe implements Imprimible{
    public String text;
    public int cantidadDePaginas;
    public String autor;
    public String revisor;

    @Override
    public void imprimir() {
        System.out.println("\nAutor:  " + this.autor + "\nRevisor: " + this.revisor + "\nCantidad de Paginas: " + this.cantidadDePaginas + "\nTexto: " + this.text);

    }

    //Constructor, getters, setters
    public Informe(String text, int cantidadDePaginas, String autor, String revisor) {
        this.text = text;
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }
}
