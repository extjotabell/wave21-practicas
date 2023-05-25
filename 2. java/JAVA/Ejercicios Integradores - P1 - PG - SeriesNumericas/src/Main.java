public class Main {
    public static void main(String[] args) {

        forDoubles serie1 = new forDoubles(2.5);

        serie1.initialize(2.0);

        serie1.next();
        serie1.next();
        serie1.next();
        serie1.next();

        serie1.reset();

        serie1.next();
        serie1.next();
        serie1.next();
    }
}
