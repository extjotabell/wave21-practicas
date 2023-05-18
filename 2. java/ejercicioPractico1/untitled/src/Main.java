public class Main {
    public static void main(String[] args) {
        String[] ciudades = new String[10];
        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asunción";
        ciudades[5] = "Sao Paulo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de Chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";

        int[][] temperaturas = new int[10][10];
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

        int menort = 0, mayort = 0;
        String ciudad_menor = null;
        String ciudad_mayor = null;
        // Press Ctrl+R or click the green arrow button in the gutter to run the code.
        for (int f = 0; f < 10; f++) {
            for (int c = 0; c < 2; c++){
                if (temperaturas[f][c] < menort){
                    menort = temperaturas[f][c];
                    ciudad_menor = ciudades[f];
                }
                if (temperaturas[f][c] > mayort){
                    mayort = temperaturas[f][c];
                    ciudad_mayor = ciudades[f];
                }
            }
        }
        String mensaje_menor = String.format("Menor temperatura en %s, con %d ºC", ciudad_menor, menort);
        System.out.println(mensaje_menor);
        String mensaje_mayor = String.format("Mayor temperatura en %s, con %d ºC", ciudad_mayor, mayort);
        System.out.println(mensaje_mayor);
    }
}