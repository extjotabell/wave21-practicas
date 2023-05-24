public class Main {
    public static void main(String[] args) {
            SerieProgresiva2 serie2 = new SerieProgresiva2();
            SerieProgresiva3 serie3 = new SerieProgresiva3();

            for (int i = 0; i < 5; i++) {
                System.out.println("SerieProgresiva2: " + serie2.siguiente());
            }

            for (int i = 0; i < 5; i++) {
                System.out.println("SerieProgresiva3: " + serie3.siguiente());
            }
    }
}
