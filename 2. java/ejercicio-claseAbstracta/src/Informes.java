public class Informes extends Pdf implements Imprimible{
    private String texto;
    private String revisor;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    public Informes( int cantidadPaginas, String autor, String texto, String revisor) {
        super(cantidadPaginas, autor);
        this.texto = texto;
        this.revisor = revisor;
    }

    public void toOneString(){
        System.out.println("ACA IMPRIMO UN Informe");
    }
    @Override
    public void imprimir(){
        this.toOneString();
    }
}
