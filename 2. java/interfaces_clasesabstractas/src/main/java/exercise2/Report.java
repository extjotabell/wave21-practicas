package exercise2;

public class Report implements Printable {
    private String text;
    private int pageCount;
    private String author;
    private String reviewer;

    public Report(String text, int pageCount, String author, String reviewer) {
        this.text = text;
        this.pageCount = pageCount;
        this.author = author;
        this.reviewer = reviewer;
    }

    public void print() {
        System.out.println("Printing Report: ");
        System.out.println("Text: " + text);
        System.out.println("Page Count: " + pageCount);
        System.out.println("Author: " + author);
        System.out.println("Reviewer: " + reviewer);
    }
}