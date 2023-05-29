import models.Cliente;
import models.Factura;
import models.Producto;
import repository.ClienteImp;
import repository.ProductoImpl;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //AGREGO CLIENTES
        Map<Integer, Cliente> mapClientes = new HashMap<>();
        ClienteImp clienteImp = new ClienteImp();
        Cliente cl1 = new Cliente("Ricardo","Montoya", 9898989);
        Cliente cl2 = new Cliente("Marta","Montoya", 6768533);
        Cliente cl3 = new Cliente("Miriam","Riquelme", 9421455);
        clienteImp.save(cl1);
        clienteImp.save(cl2);
        clienteImp.save(cl3);

        //MUESTRO LOS CLIENTES CARGADOS
        clienteImp.read();

        //ELIMINO UN CLIENTE Y MUESTRO LOS DATOS DE LOS RESTANTES
        clienteImp.delete(9898989);
        clienteImp.read();

        //CONSULTA DE CLIENTE
        Scanner teclado = new Scanner(System.in);
        Integer dni;
        System.out.println("A CONTINUACION INGRESE EL DNI DEL CLIENTE QUE DESEA VER:\n");
        dni = teclado.nextInt();
        clienteImp.search(dni);

        // PARTE II
        ProductoImpl productoImpl = new ProductoImpl();
        Producto p1 = new Producto(1, "1231GS", "PRODUCTO 1", 5, 798.9);
        Producto p2 = new Producto(2, "1232GS", "PRODUCTO 2", 10, 550);
        Producto p3 = new Producto(3, "1677GS", "PRODUCTO 3", 7, 890);
        Producto p4 = new Producto(4, "7771GS", "PRODUCTO 4", 4, 700.6);
        Producto p5 = new Producto(5, "1881GS", "PRODUCTO 5", 3, 755.9);
        productoImpl.save(p1);
        productoImpl.save(p2);
        productoImpl.save(p3);
        productoImpl.save(p4);
        productoImpl.save(p5);

        List<Factura> listFacturas = new ArrayList<>();

        // VALIDAR CLIENTE
        System.out.println("A CONTINUACION INGRESE EL DNI DEL CLIENTE QUE DESEA VER:\n");
        dni = teclado.nextInt();
        Cliente per = clienteImp.search(dni).get();
        if(per != null){
            System.out.println("PERSONA ENCONTRADA:");
        }
        else {
            per = new Cliente();
            System.out.println("PERSONA NO REGISTRADA!! \n INGRESE LOS DATOS A CONTINUACION...");
            System.out.println("Nombre: ");
            per.setNombre(teclado.next());
            System.out.println("Apellido: ");
            per.setApellido(teclado.next());
            per.setDni(dni);
            clienteImp.save(per);
        }

    }
}