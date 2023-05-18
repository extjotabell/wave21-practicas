// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        String vectorCiudades[]= new String[10];
        vectorCiudades[0]="Londres";
        vectorCiudades[1]="Madrid";
        vectorCiudades[2]="Nueva York";
        vectorCiudades[3]="Buenos Aires";
        vectorCiudades[4]="Asuncion";
        vectorCiudades[5]="Sao Paulo";
        vectorCiudades[6]="Lima";
        vectorCiudades[7]="Santiago de Chile";
        vectorCiudades[8]="Lisboa";
        vectorCiudades[9]="Tokio";

        int matrizTemperaturas[][]= new int[10][2];
        matrizTemperaturas[0][0]=-2;
        matrizTemperaturas[1][0]=-3;
        matrizTemperaturas[2][0]=-8;
        matrizTemperaturas[3][0]=4;
        matrizTemperaturas[4][0]=6;
        matrizTemperaturas[5][0]=5;
        matrizTemperaturas[6][0]=0;
        matrizTemperaturas[7][0]=-7;
        matrizTemperaturas[8][0]=-1;
        matrizTemperaturas[9][0]=-10;

        matrizTemperaturas[0][1]=33;
        matrizTemperaturas[1][1]=32;
        matrizTemperaturas[2][1]=27;
        matrizTemperaturas[3][1]=37;
        matrizTemperaturas[4][1]=42;
        matrizTemperaturas[5][1]=43;
        matrizTemperaturas[6][1]=39;
        matrizTemperaturas[7][1]=26;
        matrizTemperaturas[8][1]=31;
        matrizTemperaturas[9][1]=35;


        int posMenorTemp = 0;
        int posMayorTemp = 0;

        for (int i = 0; i < 10; i++) {
                if(matrizTemperaturas[posMenorTemp][0] > matrizTemperaturas[i][0]){
                    posMenorTemp = i;
                }
                if(matrizTemperaturas[posMayorTemp][1] < matrizTemperaturas[i][1]){
                    posMayorTemp = i;
                }
        }

        System.out.println("\n La menor temperatura la tuvo "+vectorCiudades[posMenorTemp]+ " con " + matrizTemperaturas[posMenorTemp][0]+"ºC.");
        System.out.println("\n La mayor temperatura la tuvo "+vectorCiudades[posMayorTemp]+ " con " + matrizTemperaturas[posMayorTemp][1]+"ºC.");

    }
}