package Ejercicio_integrador_parte1;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Cliente> listaClientes = new ArrayList<>();

        // Crear Objetos
        Cliente cliente1 = new Cliente(40123123, "Agustin", "Rodriguez");
        Cliente cliente2 = new Cliente(12312312, "Juana", "Martinez");
        Cliente cliente3 = new Cliente(12121212, "Pepe", "Argento");

        // Agregar Objetos a la lista
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);

        for (Cliente c : listaClientes) System.out.println(c.toString());


        System.out.println(("----------Removiendo a Pepe de la lista-------------"));

        listaClientes.remove(cliente3);

        for (Cliente c : listaClientes) System.out.println(c.toString());

        //Creo el Scanner para poder buscar el dni que me pide el ej
        Scanner lectura = new Scanner(System.in);
        System.out.println(("----------Inserte numero de DNI que desea buscar!-------------"));
        //Lo parseo a int
        int dni = Integer.parseInt(lectura.next());
        System.out.println(dni);

        //Declaro a persona null para verificar si existe el dni dentro del array
        String persona = null;
        for (Cliente c : listaClientes) {
            if (c.getDni() == dni) {
                persona = c.toString();
                break;
            }
        }

        //Si persona sigue siendo null es porque no existe el dni dentro del array de lo contrario se muestra la persona
        if (persona == null){
            System.out.println("No se encontro ninguna persona con el dni:" + dni);
        } else {
            System.out.println(persona);
        }
        // Parte 2...

        // Declaro items
        Item item1 = new Item(1,"Papel Higienico",3,200);
        Item item2 = new Item(2,"Carne",2,1000);
        Item item3 = new Item(3,"Agua",1,100);

        // Declaro arrays items
        ArrayList<Item> listaItems = new ArrayList<>();
        // Cargo los items
        listaItems.add(item1);
        listaItems.add(item2);
        listaItems.add(item3);

        int cantidad = 0;
        double costo = 0;
        double costoTotal = 0;

        // Creo un nuevo cliente para testear la verificacion futura
        Cliente cliente4 = new Cliente(1313131, "Juancin", "Ferreira");

        // Recorro la lista de items para traer el precio total de la factura
        for (Item i : listaItems) {
            cantidad =  i.getCantidadcomprada();
            costo =  i.getCostounitario();
            costoTotal = costoTotal + (cantidad * costo);
        }

        //Creo Factura
        Factura factura1 = new Factura(cliente4, listaItems, costoTotal);
        System.out.println("---------Creo la factura y la muestro------------");
        System.out.println(factura1);

        //Verifico si existe en la lista de clientes
        int dniPersona = factura1.getCliente().getDni();
        boolean verificador = false;
        for (Cliente c : listaClientes) {
            if (c.getDni() == dniPersona) {
                System.out.println("Fue verificado y existe el cliente registrado!");
                break;
            } else {
                verificador = true;
            }
        }

        // Si no existe el cliente lo agrego a la lista
        if (verificador == true) {
            listaClientes.add(factura1.getCliente());
            System.out.println("El cliente no existia y fue cargado en la coleccion de clientes");
        }

    }
}
