public class Main {
    public static void main(String[] args) {
        String[] cities = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperatures = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        int tempMax = -2;
        int tempMin = 33;

        String cityTempMax = "Londres";
        String cityTempMin = "Londres";

        for (int i = 1; i < 10; i++){
            if(tempMin > temperatures[i][0]) {
                tempMin = temperatures[i][0];
                cityTempMin = cities[i];
            }

            if(tempMax < temperatures[i][1]){
                tempMax = temperatures[i][1];
                cityTempMax = cities[i];
            }
        }

        System.out.println("Ciudad con menor temperatura: " + cityTempMin + ". Temperatura: " + tempMin);
        System.out.println("Ciudad con mayor temperatura: " + cityTempMax + ". Temperatura: " + tempMax);

    }
}