import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        // Creacion de clientes
        Cliente luz = new Cliente("Luz","Deniz","123");
        Cliente lucia = new Cliente("Lucia", "Irala","456");
        Cliente nacho = new Cliente("Ignacio","Martinez","789");

        List<Cliente> clientes = new ArrayList<>();

        clientes.add(lucia);
        clientes.add(luz);
        clientes.add(nacho);

        /*
        clientes.forEach(cliente -> System.out.println(cliente.toString()));
        System.out.println("------------------------");
        clientes.remove(1);

        clientes.forEach(cliente -> System.out.println(cliente.toString()));


        //Pedir dni por consola
        System.out.println ("Por favor ingrese el dni a buscar:");
        String dniBuscado = "";
        Scanner entradaEscaner = new Scanner (System.in);
        dniBuscado = entradaEscaner.nextLine ();

        for (Cliente client:clientes) {
            if(client.dni.equals(dniBuscado)){
                System.out.println("Se encontro el cliente:");
                System.out.println(client.toString());
            }
        }
        */

        Item pan = new Item(1,"Pan",3.0,5);
        Item arroz = new Item(2,"Arroz",4.5,10);
        Item yerba = new Item(3,"Yerba",10.0,15);

        List<Item>  productos = new ArrayList<>();
        productos.add(pan);
        productos.add(arroz);
        productos.add(yerba);

        Cliente pedro = new Cliente("Pedro","Perez","2222");

        Factura factura = new Factura(pedro,productos);

        List<Factura> facturas = new ArrayList<>();

        if(!Cliente.existeCliente(clientes,factura.getCliente())){
            clientes.add(factura.getCliente());
        }

        facturas.add(factura);

    }


}