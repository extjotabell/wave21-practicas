public class Main {
    public static void main(String[] args) {
        Series2 series2 = new Series2();
        for (int i = 0; i < 10; i++){
            System.out.println(series2.getNext());
        }

        series2.init(5);
        for (int i = 0; i < 10; i++){
            System.out.println(series2.getNext());
        }

        Series3 series3 = new Series3();
        for (int i = 0; i < 10; i++){
            System.out.println(series3.getNext());
        }

        series3.init(5);
        for (int i = 0; i < 10; i++){
            System.out.println(series3.getNext());
        }
    }
}