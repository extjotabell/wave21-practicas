package EjercicioIntegrador;

import EjercicioIntegrador.model.Cliente;
import EjercicioIntegrador.model.Factura;
import EjercicioIntegrador.model.Item;
import EjercicioIntegrador.repository.RepoCliente;
import EjercicioIntegrador.repository.RepoFactura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        RepoCliente repoCliente = new RepoCliente();
        RepoFactura repoFactura = new RepoFactura();
        //Clientes
        Cliente cliente1 = new Cliente("45654545", "Juan", "Rodriguez");
        Cliente cliente2 = new Cliente("123","Pedro", "Sanchez");
        Cliente cliente3 = new Cliente("121221212", "Jose", "Fagundez");

        repoCliente.agregar(cliente1);
        repoCliente.agregar(cliente2);
        repoCliente.agregar(cliente3);


        //Items
        Item item1 = new Item(1,"Azucar", 5, 60);
        Item item2 = new Item(2,"Harina", 2, 50);
        Item item3 = new Item(3,"Sal", 3, 30);
        Item item4 = new Item(4,"Leche", 5, 20);

        Factura factura = new Factura(cliente1);
        factura.agregarItems(item1);
        factura.agregarItems(item2);
        factura.agregarItems(item3);
        factura.agregarItems(item4);
        factura.calcularTotal();

        if(repoCliente.buscar(factura.getCliente().getDni()).isEmpty()){
            Cliente clienteNuevo = new Cliente("121","Pedro", "Fernandez");
            repoCliente.agregar(clienteNuevo);
            factura.setCliente(clienteNuevo);
        }

        repoFactura.agregar(factura);


        System.out.println("------Lista original-------");
        mostrarClientes(repoCliente.traerTodos());
        repoCliente.eliminar(cliente1.getDni());
        System.out.println("------Lista con un elemento eliminado-------");
        mostrarClientes(repoCliente.traerTodos());

        /////////////////buscar cliente por dni ingresado
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa un DNI");
        Integer dniIngresado = sc.nextInt();
        String dniString = dniIngresado.toString();
        Optional<Cliente> clienteEncontrado = repoCliente.buscar(dniString);
        if(!clienteEncontrado.isEmpty()){
            System.out.println(repoCliente.mostrarCliente(dniString));
        }
        else{
            System.out.println("Cliente no encontrado con el dni ingresado");
        }
    }
    ///////////////////////
    public static  void mostrarClientes(List<Cliente> listaClientes){
        String mensaje = "Clientes: ";
        for(int i = 0; i < listaClientes.size(); i++){
            Cliente cliente = listaClientes.get(i);
            mensaje += "Nombre: " + cliente.getNombre() + ".Apellido: " + cliente.getApellido() + ". Dni: " + cliente.getDni();
        }
        System.out.println(mensaje);
    }
}
