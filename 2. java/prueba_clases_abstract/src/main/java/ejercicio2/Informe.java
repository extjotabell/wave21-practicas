package ejercicio2;

public class Informe implements IImprimible{
    private String nLong;
    private int cantPag;
    private String autor;
    private String revisor;

    public Informe(String nLong, int cantPag, String autor, String revisor) {
        this.nLong = nLong;
        this.cantPag = cantPag;
        this.autor = autor;
        this.revisor = revisor;
    }

    public String getnLong() {
        return nLong;
    }

    public void setnLong(String nLong) {
        this.nLong = nLong;
    }

    public int getCantPag() {
        return cantPag;
    }

    public void setCantPag(int cantPag) {
        this.cantPag = cantPag;
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

    @Override
    public String toString() {
        return "Informes{" +
                "nLong=" + nLong +
                ", cantPag=" + cantPag +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println(toString());
    }
}