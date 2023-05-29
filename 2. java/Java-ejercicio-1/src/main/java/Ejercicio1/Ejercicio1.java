package Ejercicio1;

public class Ejercicio1 {
    public static void main (String args[]) {
        String[] ciudades = {
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asunción",
                "São Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"
        };

        int[][] temp = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        int maxTemp = Integer.MIN_VALUE;
        int indiceCiudadMaxTemp = -1;

        int minTemp = Integer.MAX_VALUE;
        int indiceCiudadMinTemp= -1;

        for (int i = 0; i < temp.length; i++){
            if (minTemp > temp[i][0]){
                minTemp = temp[i][0];
                indiceCiudadMinTemp = i;
            }

            if (maxTemp < temp[i][1]){
                maxTemp = temp[i][1];
                indiceCiudadMaxTemp = i;
            }
        }

        System.out.println("La menor temperatura la tuvo " + ciudades[indiceCiudadMinTemp] + ", con " + minTemp);
        System.out.println("La mayor temperatura la tuvo " + ciudades[indiceCiudadMaxTemp] + ", con " + maxTemp);
    }
}
