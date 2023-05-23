package Ejercicio2;

public class Informe  implements Documento{
    private String texto;
    private int cantidadPaginas;
    private Persona autor;

    public String getTexto() {
        return texto;
    }

    public Informe(String texto, int cantidadPaginas, Persona autor) {
        this.texto = texto;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
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

    @Override
    public String imprimir() {
        return "Ejercicio2.Informe: " +
                "texto='" + texto + '\'' +
                ", cantidadPaginas=" + cantidadPaginas +
                ", autor=" + autor.getNombre() + " " + autor.getApellido();
    }
}


