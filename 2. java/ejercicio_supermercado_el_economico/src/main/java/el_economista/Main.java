package el_economista;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static RepositorioClientes repositorioClientes;
    private static RepositorioFacturas repositorioFacturas;

    public static void main(String[] args) {
        repositorioClientes = new RepositorioClientes();
        repositorioFacturas = new RepositorioFacturas();

        agregarClientes();

        System.out.println("Mostrando los clientes de la colección");
        mostrarClientes();

        eliminarCliente(2);

        System.out.println("Mostrando lista luego de la eliminación");
        mostrarClientes();

        buscarClienteDesdeTeclado();

        System.out.println("Mostrando lista de facturas antes de agregar nueva factura");
        mostrarFacturas();

        agregarFacturaARepositorio(crearFactura(3));

        System.out.println("Mostrando facturas luego de agregar la factura anterior");
        mostrarFacturas();

    }

    private static void buscarClienteDesdeTeclado() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un dni: ");
        String dni = sc.next();
        Cliente clienteBuscado = repositorioClientes.getElementos().stream().filter(c -> c.getDni().equals(dni)).findAny().orElse(null);
        if (clienteBuscado == null) {
            System.out.println("No se encontro un cliente con el dni ingresado");
        } else {
            System.out.println(clienteBuscado);
        }
    }

    private static void agregarClientes() {
        Cliente cliente1 = new Cliente("1", "Juan", "Pérez");
        Cliente cliente2 = new Cliente("2", "Carlos", "Cabal");
        Cliente cliente3 = new Cliente("3", "Gaston", "La Parca");
        repositorioClientes.agregarElemento(cliente1);
        repositorioClientes.agregarElemento(cliente2);
        repositorioClientes.agregarElemento(cliente3);
    }

    private static void mostrarClientes() {
        System.out.println("Se tiene los siguientes clientes registrados: [");
        repositorioClientes.getElementos().forEach(c -> System.out.println("\t" + c));
        System.out.println("]");
    }

    private static void eliminarCliente(int id) {
        Cliente cliente = repositorioClientes.getElemento(id);
        System.out.println("Eliminando al cliente con dni " + cliente.getDni());
        repositorioClientes.removerElemento(cliente);
    }

    private static void mostrarFacturas() {
        System.out.println("Se tiene las siguientes facturas registradas: [");
        repositorioFacturas.getElementos().forEach(System.out::println);
        System.out.println("]");
    }

    private static Factura crearFactura(int idCliente) {
        Factura factura = new Factura(repositorioClientes.getElemento(idCliente));
        factura.setProductos(crearProductos());
        return factura;
    }

    private static List<Item> crearProductos() {
        Item producto1 = new Item(1, "Producto 1", 3, 25);
        Item producto2 = new Item(2, "Producto 2", 5, 10);
        return List.of(producto1, producto2);
    }

    private static void agregarFacturaARepositorio(Factura factura) {
        if (!repositorioClientes.existeElemento(factura.getCliente())) {
            System.out.println("Cliente no se encontro en la coleccion, sera agregado");
            repositorioClientes.agregarElemento(factura.getCliente());
        }
        repositorioFacturas.agregarElemento(factura);
    }
}
