package ejercicio1;

public class Main {
    public static void main(String[] args) {
        String[] ciudades = new String[10];
        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asunción";
        ciudades[5] = "São Paulo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de Chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";

        int[][] temperaturas = new int[10][2];
        temperaturas[0][0] = -2;
        temperaturas[0][1] = 33;
        temperaturas[1][0] = -3;
        temperaturas[1][1] = 32;
        temperaturas[2][0] = -8;
        temperaturas[2][1] = 27;
        temperaturas[3][0] = 4;
        temperaturas[3][1] = 37;
        temperaturas[4][0] = 6;
        temperaturas[4][1] = 42;
        temperaturas[5][0] = 5;
        temperaturas[5][1] = 43;
        temperaturas[6][0] = 0;
        temperaturas[6][1] = 39;
        temperaturas[7][0] = -7;
        temperaturas[7][1] = 26;
        temperaturas[8][0] = -1;
        temperaturas[8][1] = 31;
        temperaturas[9][0] = -10;
        temperaturas[9][1] = 35;

        String ciudadMasTemperatura = "";
        int mayorTemperatura = 0;

        String ciudadMenorTemperatura = "";
        int menorTemperatura = 10;

        for(int i= 0; i < 10; i++){
            for(int j= 0; j < 2; j++){
                if (j == 0){
                    if(temperaturas[i][j] < menorTemperatura){
                        ciudadMenorTemperatura = ciudades[i];
                        menorTemperatura = temperaturas[i][j];
                    }
                }else{
                    if(temperaturas[i][j] > mayorTemperatura){
                        ciudadMasTemperatura = ciudades[i];
                        mayorTemperatura = temperaturas[i][j];
                    }
                }
            }
        }

        System.out.println(String.format("La ciudad con menor temperatura es %s con %s grados", ciudadMenorTemperatura, String.valueOf(menorTemperatura)));
        System.out.println(String.format("La ciudad con mayor temperatura es %s con %s grados", ciudadMasTemperatura, String.valueOf(mayorTemperatura)));
    }
}
