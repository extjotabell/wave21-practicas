public class Informes implements Imprimble{
    private String text;
    private int pages;
    private String author;
    private String reviewer;

    public Informes(String text, int pages, String author, String reviewer) {
        this.text = text;
        this.pages = pages;
        this.author = author;
        this.reviewer = reviewer;
    }

    @Override
    public void imprimir() {
        System.out.println(
                new StringBuilder("Texto: ").append(this.text).append("\n")
                        .append("Cantidad de paginas: ").append(this.pages).append("\n")
                        .append("Autor: ").append(this.author).append("\n")
                        .append("Revisor: ").append(this.reviewer).append("\n")
        );
    }
}
