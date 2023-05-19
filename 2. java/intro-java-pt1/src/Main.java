public class Main {
    public static void main(String[] args) {
        String [] cities = {"Londres","Madrid","Nueva York","Buenos Aires","Asuncion","Sao Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};
        int [] min_temps = {-2,-3,-8,4,6,5,0,-7,-1,-10};
        int [] max_temps = {33,32,27,37,42,43,39,26,31,35};
        int min_temp = 0;
        int max_temp = 0;

        for (int i=1;i<10;i++){
            if (min_temps[i]<min_temps[min_temp]){
                min_temp=i;
            }
            if(max_temps[i]>max_temps[max_temp]){
                max_temp=i;
            }
        }

        System.out.println("La temperatura minima es de " + min_temps[min_temp] + " en " + cities[min_temp]);
        System.out.println("La temperatura max es de " + max_temps[max_temp] + " en " + cities[max_temp]);
    }
}
