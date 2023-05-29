import clases.Cliente;
import clases.Factura;
import clases.Item;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Cliente juan = new Cliente("43542234", "Juan", "Galarza");
        Cliente roberto = new Cliente("43541234", "Roberto", "Chico");
        Cliente sofia = new Cliente("43232124", "Sofia", "Wang");

        List<Cliente> clientes = new ArrayList<>(Arrays.asList(juan, roberto, sofia));

        for (Cliente cliente :
                clientes) {
            System.out.println(cliente.toString());
        }

        clientes.remove(roberto);

        for (Cliente cliente :
                clientes){
            System.out.println(cliente.toString());
        }

        Scanner scanner= new Scanner(System.in).useDelimiter("\n");

        System.out.println("Ingrese el numero de un DNI para buscar entre los clientes");
        String dniABuscar= scanner.next();
        List<Cliente> clientesConDniIngresado = clientes.stream().filter(cliente -> cliente.getDni().equals(dniABuscar)).collect(Collectors.toList());
        if(clientesConDniIngresado!=null){
            for (Cliente cliente:
                 clientesConDniIngresado) {
                System.out.println("El cliente "+cliente.getNombre()+ " "+cliente.getApellido()+ " contiene el dni "+dniABuscar);
            }
        }

        //Parte 2

        Item item= new Item("1","Pan",3,4d);
        Item item2= new Item("2","Manteca",6,32d);

        Factura factura= new Factura(clientes,Arrays.asList(item,item2));

        System.out.println(factura);
    }
}