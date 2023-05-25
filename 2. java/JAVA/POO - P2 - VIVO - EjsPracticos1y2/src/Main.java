import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        PracticaExcepciones pe = new PracticaExcepciones();

        try{
            int cociente = pe.b / pe.a ;
        }catch(ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir por cero");
            //System.out.println("No se puede dividir por cero" + e.getMessage());
        }finally{
            System.out.println("Se ha producido un error");
        }

        Producto prod1 = new Producto("Milanesa", 200);
        Perecedero prod2 = new Perecedero("Pollo", 300, 4);
        Perecedero prod3 = new Perecedero("Carne", 400, 3);
        NoPerecedero prod4 = new NoPerecedero("Arroz", 100, "Comida");

        //System.out.println(prod4.calcular(2));

        ArrayList<Producto> productos = new ArrayList<Producto>();
        productos.add(prod1);
        productos.add(prod2);
        productos.add(prod3);
        productos.add(prod4);

        double total = 0;
        for(int i = 0; i < productos.size(); i++){
            total += productos.get(i).calcular(1);
        }
        System.out.println(total);

    }
}