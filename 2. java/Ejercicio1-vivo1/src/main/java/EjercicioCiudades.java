public class EjercicioCiudades {
    public static void main(String[] args) {
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Sap Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperatura = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        int menorTemperatura = temperatura[0][0]; // se inicia la menor temperatura con el primer valor de Londres
        String ciudadMenorTemperatura = ciudades[0]; // se inicia la ciudad de la menor temperatura con la primera ciudad

        int mayorTemperatura = temperatura[0][0]; // aqui se inicia la mayor temperatura con el primer valor de Londres
        String ciudadMayorTemperatura = ciudades[0]; // se iniciia la ciudad de la mayor temperatura con la primera ciudad

        for (int i = 0; i < temperatura.length; i++) {
            if (temperatura[i][0] < menorTemperatura) {
                menorTemperatura = temperatura[i][0];
                ciudadMenorTemperatura = ciudades[i];
            }

            if (temperatura[i][1] > mayorTemperatura) {
                mayorTemperatura = temperatura[i][1];
                ciudadMayorTemperatura = ciudades[i];
            }
        }

        System.out.println("La menor temperatura fue " + menorTemperatura + " en " + ciudadMenorTemperatura);
        System.out.println("La mayor temperatura fue " + mayorTemperatura + " en " + ciudadMayorTemperatura);
    }
}
