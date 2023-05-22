package exercise2;

public class PdfBook implements Printable {
    private int pageCount;
    private String author;
    private String title;
    private String genre;

    public PdfBook(int pageCount, String author, String title, String genre) {
        this.pageCount = pageCount;
        this.author = author;
        this.title = title;
        this.genre = genre;
    }

    public void print() {
        System.out.println("Printing PDF Book: ");
        System.out.println("Page Count: " + pageCount);
        System.out.println("Author: " + author);
        System.out.println("Title: " + title);
        System.out.println("Genre: " + genre);
    }
}