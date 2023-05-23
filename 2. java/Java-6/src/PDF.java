public class PDF implements Imprimble{
    private int pages;
    private String author;
    private String title;
    private String genre;

    public PDF(int pages, String author, String title, String genre) {
        this.pages = pages;
        this.author = author;
        this.title = title;
        this.genre = genre;
    }

    @Override
    public void imprimir() {
        System.out.println(
                new StringBuilder("Cantidad de paginas: ").append(this.pages).append("\n")
                        .append("Nombre del autor: ").append(this.author).append("\n")
                        .append("Titulo: ").append(this.title).append("\n")
                        .append("Genero: ").append(this.genre).append("\n")
        );
    }
}
