package repository;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ClienteImp implements CRUDRepository<Cliente> {

    List<Cliente> clientes = new ArrayList<Cliente>();

    public Cliente crearObjeto() {
        Cliente cli = new Cliente();

        System.out.println("Se esta creando un cliente.\n");
        System.out.println("DNI: \n");
        Scanner keyboard = new Scanner(System.in);
        Long op = keyboard.nextLong();
        cli.setDni(op);

        System.out.println("Nombre: \n");
        String name = keyboard.next();
        cli.setNombre(name);

        System.out.println("Apellido: \n");
        String surname = keyboard.next();
        cli.setApelido(surname);

        return cli;
    }

    @Override
    public void save(Cliente obj) {
        clientes.add(obj);

    }

    @Override
    public void mostrarPantalla() {
        if(clientes.isEmpty()){
            System.out.println("No hay Clientes en el sistema!");
        }
        for (Cliente c : clientes) {
            System.out.println(c.toString());
        }
    }

    @Override
    public Optional<Cliente> buscar(Long dniBuscado) {
        boolean flag = false;
        for (Cliente c : clientes) {
            if (c.getDni().equals(dniBuscado)) {
                System.out.println(c.toString());
                flag = true;
                return Optional.of(c);
            }
        }

        if (flag == false) {
            System.out.println("No se encontro el Cliente!");
        }

        return Optional.empty();
    }

    @Override
    public void eliminar(Long dniBorrado) {
        Optional<Cliente> cli = this.buscar(dniBorrado);

        if (cli.isEmpty()) {
            System.out.println("No existe el cliente!");
        } else{
            clientes.remove(cli.get());
            System.out.println("Cliente eliminado con éxito!");
        }
    }

    public void modificar(){
        this.mostrarPantalla();
        System.out.println("Elija un Cliente a modificar:");
        Scanner keyboard = new Scanner(System.in);
        Long cod = keyboard.nextLong();
        int index = 0
                ;
        boolean flag = false;
        for(int i = 0; i < clientes.size(); i++){
            if (clientes.get(i).getDni().equals(cod)){
                index = i;
                flag = true;
                break;
            }
        }
        if(!flag){
            System.out.println("No se encontro el Cliente.");
        }else{
            clientes.set(index, this.crearObjeto());
        }
    }

    @Override
    public List<Cliente> traerTodos() {
        return clientes;
    }
}
