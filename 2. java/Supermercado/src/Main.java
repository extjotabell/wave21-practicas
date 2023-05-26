import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Intancia de repos
        Repositorio<Cliente> repositorioCliente = new Repositorio<>();
        Repositorio<Factura> repositorioFactura = new Repositorio<>();
        Repositorio<Producto> repositorioProducto = new Repositorio<>();

        //Crear colleccion clientes
        repositorioCliente.crear(new Cliente(123456789L, "Ernesto", "Perez"));
        repositorioCliente.crear(new Cliente(987654321L, "Arnulfo", "Rodriguez"));
        repositorioCliente.crear(new Cliente(678954321L, "Andrea", "Gutierrez"));

        //Recorrer la coleccion y mostrar en pantalla
        System.out.println(repositorioCliente.obtnerTodos());

        //Eliminar un cliente y mostrar por pantalla
        System.out.println("Se elimina el cliente con dni 123456789");
        repositorioCliente.eliminar(123456789L);
        repositorioCliente.obtnerTodos().forEach(System.out::println);

        //Consultar cliente por ingreso de usuario
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el dni del cliente a consultar: ");
        Long dni = scanner.nextLong();
        Cliente clienteBuscado = repositorioCliente.obtenerUno(dni);
        if(clienteBuscado != null){
            System.out.println("Datos del cliente: " + clienteBuscado);
        }else {
            System.out.println("No se encontró ningun cliente con este dni");
        }

        //Validar si el cliente esta registrado o no
        Cliente cliente2 = new Cliente(678954321L, "Andrea", "Zapata");
        //El metodo crear valida internamente si el cliente existe y actualiza, sino, agrega uno nuevo
        repositorioCliente.crear(cliente2);

        //Crear lista de items/productos
        repositorioProducto.crear(new Producto(10000001L, "Camiseta", 2, 120));
        repositorioProducto.crear(new Producto(10000002L, "Medias", 1, 5));
        repositorioProducto.crear(new Producto(10000003L, "Gorra", 1, 80));
        repositorioProducto.crear(new Producto(10000004L, "Pantalon", 2, 160));

        //Calcular total
        double total = repositorioProducto.obtnerTodos().stream().mapToDouble(producto -> producto.getCantidad() * producto.getCosto()).sum();

        //Crear nueva Factura
        repositorioFactura.crear(new Factura(9999999L,cliente2, repositorioProducto.obtnerTodos(), total));
    }
}