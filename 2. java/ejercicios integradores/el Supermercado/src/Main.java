import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public class aux {
        public static Cliente check(ArrayList<Cliente> clientes, String dni){
            for (Cliente cliente: clientes){
                if (dni.equals(cliente.getDni())){
                    return cliente;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("123456789", "John", "Doe");
        Cliente cliente2 = new Cliente("987654321", "Jane", "Smith");
        Cliente cliente3 = new Cliente("456789123", "Bob", "Johnson");
        ArrayList<Cliente> clientes = new ArrayList<>(List.of(cliente1,cliente2,cliente3));

        Item item1 = new Item(1, "Item 1", 10, 50);
        Item item2 = new Item(2, "Item 2", 5, 30);
        Item item3 = new Item(3, "Item 3", 3, 15);
        Item item4 = new Item(4, "Item 4", 8, 20);
        Item item5 = new Item(5, "Item 5", 2, 10);
        List<Item> items = new ArrayList<>(List.of(item1,item2,item3,item4,item5));

        ArrayList<Factura> facturas;





        for(Cliente cliente : clientes){
            System.out.println(cliente.toString());
        }
        System.out.println("-------------");

        clientes.remove(2);

        for(Cliente cliente : clientes){
            System.out.println(cliente.toString());
        }

        System.out.println("-------------");

        System.out.print("pls senpai, enter your dni UwU to see if you are in the lisi OwO: ");
        Scanner in = new Scanner(System.in);
        String dni = in.nextLine();
        Cliente c = aux.check(clientes,dni);
        if(Objects.nonNull(c)) System.out.println("Wow senpai you are in the list UwU! here´s your data:\n" + c);
        else System.out.println("Sorry senpai, you are not in the list UnU");

        System.out.println("-------------");


        System.out.println("Senpai, ingres tu dni porfavor para hacer tu factura UwU: ");
        dni = in.nextLine();
        c = aux.check(clientes,dni);
        if (Objects.nonNull(c)){
            Factura factura = new Factura(c,items);
            System.out.println("Muy bien senpai, aqui esta tu factura UwU:");
            System.out.println(factura.getCliente().toString());
            for (Item item:factura.getItems()){
                System.out.println(item);
            }
            factura.calcularTotal();
            System.out.println("Tu total de compre es: "+factura.getTotal()+" Uwu");
        }
        else{
            System.out.println("Oh no senpai, no estas regristrado OwO! Dame tu nombre y apellido para registrate: ");
            String datos = in.nextLine();
            String[] nombreApellido = datos.split(",",2);
            Cliente cliente = new Cliente(dni,nombreApellido[0],nombreApellido[1]);
            Factura factura = new Factura(cliente,items);
            System.out.println("Muy bien senpai, aqui esta tu factura UwU:");
            System.out.println(factura.getCliente().toString());
            for (Item item:factura.getItems()){
                System.out.println(item);
            }
            factura.calcularTotal();
            System.out.println("Tu total de compre es: "+factura.getTotal()+" Uwu");

        }





    }
}