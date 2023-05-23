package ejercicio_documentos;

public class Informes implements Imprimible{
    private String texto;
    private Persona autor;
    private Persona revisor;

    public Informes(String texto, Persona autor, Persona revisor) {
        this.texto = texto;
        this.autor = autor;
        this.revisor = revisor;
    }


    @Override
    public void imprimir() {
        System.out.println( "El informe dice: " +
                "" + texto + '\'' +
                ". Su autor es " + autor.getNombre() +
                " y su revisor es " + revisor.getNombre());
    }
}
