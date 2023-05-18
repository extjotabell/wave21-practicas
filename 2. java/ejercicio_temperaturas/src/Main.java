public class Main {
    public static void main(String[] args) {
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
        int[][] temperaturas = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        int temperaturaMaxima = Integer.MIN_VALUE;
        int indiceDeCiudadConTemperaturaMaxima = -1;

        int temperaturaMinima = Integer.MAX_VALUE;
        int indiceDeCiudadConTemperaturaMinima = -1;

        for (int f = 0; f < temperaturas.length; f++){
            if(temperaturaMinima > temperaturas[f][0]){
                temperaturaMinima = temperaturas[f][0];
                indiceDeCiudadConTemperaturaMinima = f;
            }

            if (temperaturaMaxima < temperaturas[f][1]){
                temperaturaMaxima = temperaturas[f][1];
                indiceDeCiudadConTemperaturaMaxima = f;
            }
        }

        System.out.println("La menor temperatura se registro en " + ciudades[indiceDeCiudadConTemperaturaMinima] + ", con " + temperaturaMinima);
        System.out.println("La mayor temperatura se registro en " + ciudades[indiceDeCiudadConTemperaturaMaxima] + ", con " + temperaturaMaxima);
    }
}
