public class Main {
    public static void main(String[] args) {
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de chile", "Lisboa", "Tokio"};
        int [][] temperaturas = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};
        int menor = 0, mayor = 0;
        int indiceCiudadMenor = 0,indiceCiudadMayor = 0;

        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i][0] < menor) {
                menor = temperaturas[i][0];
                indiceCiudadMenor = i;
            }
            if (temperaturas[i][1] > mayor) {
                mayor = temperaturas[i][1];
                indiceCiudadMayor = i;
            }
        }
        System.out.println("la menor temperatura la tuvo "+ciudades[indiceCiudadMenor]+", con "+menor+"º C.");
        System.out.println("la mayor temperatura la tuvo "+ciudades[indiceCiudadMayor]+", con "+mayor+"º C.");
    }
}