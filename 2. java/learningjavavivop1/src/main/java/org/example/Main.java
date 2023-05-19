package org.example;

public class Main {
    public static void main(String[] args) {
        String[] cities = new String[10];
        cities[0] = "Londres";
        cities[1] = "madrid";
        cities[2] = "nueva york";
        cities[3] = "buenos aires";
        cities[4] = "asuncion";
        cities[5] = "sao paulo";
        cities[6] = "lima";
        cities[7] = "santiago de chile";
        cities[8] = "lisboa";
        cities[9] = "tokio";

        float[][] temperaturesByCity = {{-2f, 33f}, {-3f, 32f}, {-8f, 27f}, {4f,37f},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        float temperatureMax = 0f;
        float temperatureMin = 0f;
        int idxTemperatureMax = 0;
        int idxTemperatureMin = 0;
        for (int j = 0; j < temperaturesByCity.length; j++) {
            if (temperaturesByCity[j][0] < temperatureMin) {
                temperatureMin = temperaturesByCity[j][0];
                idxTemperatureMin = j;
            }

            if (temperaturesByCity[j][1] > temperatureMax) {
                temperatureMax = temperaturesByCity[j][1];
                idxTemperatureMax = j;
            }
        }

        //System.out.println("temperature max: " + temperatureMax + " idx: " + idxTemperatureMax + " city: " + cities[idxTemperatureMax]);
        //System.out.println("temperature min: " + temperatureMin + " idx: " + idxTemperatureMin + " city: " + cities[idxTemperatureMin]);

        System.out.println("temperature max: " + temperatureMax + " city: " + cities[idxTemperatureMax]);
        System.out.println("temperature min: " + temperatureMin + " city: " + cities[idxTemperatureMin]);
    }
}