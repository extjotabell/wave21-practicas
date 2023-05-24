import clases.IntegerSeries;

public class Main {
    public static void main(String[] args) {
        IntegerSeries series2 = new IntegerSeries(0, 2);
        for (int i = 0; i < 10; i++){
            System.out.println(series2.getNext());
        }

        series2.init(5);
        for (int i = 0; i < 10; i++){
            System.out.println(series2.getNext());
        }

        IntegerSeries series3 = new IntegerSeries(5, 3);
        for (int i = 0; i < 10; i++){
            System.out.println(series3.getNext());
        }

        series3.init(5);
        for (int i = 0; i < 10; i++){
            System.out.println(series3.getNext());
        }
    }
}