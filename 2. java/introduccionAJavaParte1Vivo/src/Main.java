//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        String[] Ciudades = new String[]{"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunciòn", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] Temperaturas = new int[][]{{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};
        String ciudadMayor = "";
        String ciudadMenor = "";
        int menorTemp = 0;
        int mayorTemp = 0;

        for(int i = 0; i < 10; ++i) {
            if (Temperaturas[i][0] <= menorTemp) {
                menorTemp = Temperaturas[i][0];
                ciudadMenor = Ciudades[i];
            }

            if (Temperaturas[i][1] >= mayorTemp) {
                mayorTemp = Temperaturas[i][1];
                ciudadMayor = Ciudades[i];
            }
        }

        System.out.println("la ciudad de menor temperatura registrada es " + ciudadMenor + " con una temperatura de " + menorTemp);
        System.out.println("la ciudad de mayor temperatura registrada es " + ciudadMayor + " con una temperatura de " + mayorTemp);
    }
}
