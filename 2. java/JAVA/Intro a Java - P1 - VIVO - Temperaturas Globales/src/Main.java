public class Main {
    public static void main(String[] args) {
        String[] ciudades = {"Londres","Madrid","Nueva York","Buenos Aires","Asuncion","Sao Paulo","Lima","Santiago","Lisboa","Tokio"};
        int[][] temps = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35} };
        int min = 0, max = 0, minPos = 0, maxPos = 0;
        int i = 0;
        while (i < ciudades.length) {
            if (temps[i][0] < min) {
                min = temps[i][0];
                minPos = i;
            }
            if (temps[i][1] > max) {
                max = temps[i][1];
                maxPos = i;
            }
            i++;
        }
        System.out.println("La menor temperatura la tuvo " + ciudades[minPos] + ", con " + min);
        System.out.println("La mayor temperatura la tuvo " + ciudades[maxPos] + ", con " + max);
    }
}