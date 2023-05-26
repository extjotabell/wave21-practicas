import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("123456789", "John", "Doe");
        Cliente cliente2 = new Cliente("987654321", "Jane", "Smith");
        Cliente cliente3 = new Cliente("456789123", "Bob", "Johnson");
        ArrayList<Cliente> clientes = new ArrayList<>(List.of(cliente1,cliente2,cliente3));

        for(Cliente cliente : clientes){
            System.out.println(cliente.toString());
        }
        System.out.println("-------------");

        clientes.remove(2);

        for(Cliente cliente : clientes){
            System.out.println(cliente.toString());
        }

        System.out.println("-------------");

        System.out.println("pls senpai, enter your dni UwU to see if you are in the lisi OwO: ");
        Scanner in = new Scanner(System.in);
        String dni = in.nextLine();
        for (Cliente cliente: clientes){
            if (dni.equals(cliente.getDni())){
                System.out.println("Wow senpai you are in the list UwU! here´s your data:\n" + cliente);
                return;
            }
        }

        System.out.println("Sorry senpai, you are no in the list UnU");

        

    }
}