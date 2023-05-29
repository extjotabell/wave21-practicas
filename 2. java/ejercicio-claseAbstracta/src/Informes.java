public class Informes  implements Imprimible{
    private String texto;
    private String revisor;
    private String titulo;
    private String autor;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

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



    public void toOneString(){
        System.out.println("ACA IMPRIMO UN Informe");
    }
    @Override
    public void imprimir(){
        this.toOneString();
    }
}
