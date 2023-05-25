package EjercicioIntegrador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Cliente> listaClientes = new ArrayList<>();
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("45654545", "Juan", "Rodriguez");
        Cliente cliente2 = new Cliente("123","Pedro", "Sanchez");
        Cliente cliente3 = new Cliente("121221212", "Jose", "Fagundez");
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);

        System.out.println("------Lista original-------");
        mostrarClientes();
        eliminarCliente(cliente1);
        System.out.println("------Lista con un elemento eliminado-------");
        mostrarClientes();

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa un DNI");
        Integer dniIngresado = sc.nextInt();
        String dniString = dniIngresado.toString();
        Cliente clienteEncontrado = buscarCliente(dniString);
        if(clienteEncontrado !=null){
            System.out.println("Nombre: " + clienteEncontrado.getNombre() + ". Apellido: " + clienteEncontrado.getApellido() + ". Dni: " + clienteEncontrado.dni);
        }
        else{
            System.out.println("Cliente no encontrado con el dni ingresados");
        }
    }

    private static void mostrarClientes() {
        for (Cliente c: listaClientes) {
            System.out.println(c.toString());
        }
    }

    private static void eliminarCliente(Cliente cliente){
        listaClientes.remove(cliente);
    }

    private static Cliente buscarCliente(String dniIngresado) {
        int i = 0;
        boolean encontre = false;
        Cliente cliente = null;
        while (i < listaClientes.size() && !encontre){
            if(listaClientes.get(i).getDni().equals(dniIngresado)){
                encontre = true;
                cliente = listaClientes.get(i);
            }
            i++;
        }
        return cliente;
    }
}
