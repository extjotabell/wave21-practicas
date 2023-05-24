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
    }
}
