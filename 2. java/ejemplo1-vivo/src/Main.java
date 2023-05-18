public class Main {
    public static void main(String[] args) {
        // Solo para tener en cuenta se agregan dos formas de inicialización de variables.

        String ciudades[] = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Säo Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        // Otra forma de inicialización. (Otra forma: { {0, 0}, {0, 0} ... } )
        int temperaturas[][] = new int[10][10];
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

        // Inicialización de variables.
        int temperaturaMenor = 999;
        int temperaturaMayor = -999;
        String ciudadMayor = "";
        String ciudadMenor = "";

        for (int f = 0; f< ciudades.length; f++) {
            for (int c = 0; c < ciudades.length; c++) {
                if (temperaturas[f][c] > temperaturaMayor){
                    temperaturaMayor = temperaturas[f][c];
                    ciudadMayor = ciudades[c];
                }

                if (temperaturas[f][c] < temperaturaMenor){
                    temperaturaMenor = temperaturas[f][c];
                    ciudadMenor = ciudades[f];
                }
            }
        }

        System.out.println("La ciudad con menor temperatura es: " + ciudadMenor + " con una temperatura de: " + temperaturaMenor + " y la ciudad con mayor temperatura es " + ciudadMayor + " con una temperatura de " + temperaturaMayor);
    }
}