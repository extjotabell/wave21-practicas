import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        List<String> listaPersonas = new Arraylist<String>();

        // Press Opt+Enter with your caret at the highlighted text to see how
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asucion", "Sao Paulo", "Lima",

                "Santiago de Chile", "Lisboa", "Tokio" } ;
        //declaro una matriz bidimensional de 10 elementos por cada dimension

        //int[][] temperaturas = new int[2][10];
        //harcodeo los elementos de cada dimension
        //temperaturas[0] = new int[]{-2, -3, -8, 4, 6, 5, 0, -7, -1, -10};
        //temperaturas[1] = new int[]{33, 32, 27, 42, 43, 39, 26, 31, 35};
        int[][] temperaturas = {
                {-2, -3, -8, 4, 6, 5, 0, -7, -1, -10},
                {33, 32, 27, 37, 42, 43, 39, 26, 31, 35}

        };
        String ciudadMayorTemp = "";
        int mayorTemp = 0 ;
        String ciudadMenorTemp = ciudades[0];
        int menorTemp = temperaturas[0][0];

        for ( int i = 0; i < ciudades.length ; i++ ){
            if( temperaturas[0][i] < menorTemp ){
                menorTemp = temperaturas[0][i];
                ciudadMenorTemp = ciudades[i];
            }
            if(temperaturas[1][i] > mayorTemp){
                mayorTemp = temperaturas[1][i];
                ciudadMayorTemp = ciudades[i];
            }
        }

        System.out.println("La ciudad con mayor temperatura es " + ciudadMayorTemp + " con: "+ mayorTemp + " grados");
        System.out.println("La ciudad con menor temperatura es " + ciudadMenorTemp + " con: "+ menorTemp + " grados");


    }
}