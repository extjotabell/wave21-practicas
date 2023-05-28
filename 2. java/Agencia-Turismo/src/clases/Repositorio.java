package clases;

import java.util.*;
import java.util.stream.Collectors;

public class Repositorio {
    private Map<Cliente, List<Localizador>> repoClientes;

    public Repositorio() {
        this.repoClientes = new HashMap<Cliente, List<Localizador>>();
    }

    public Map<Cliente, List<Localizador>> getRepoClientes() {
        return repoClientes;
    }

    public void setRepoClientes(Map<Cliente, List<Localizador>> repoClientes) {
        this.repoClientes = repoClientes;
    }

    public void cargarLocalizadorACliente(Cliente cl, List<Reserva> list, boolean completa){
        Localizador loc = new Localizador(cl, list, 0);
        List<Localizador> listLoc;
        double total = list.stream()
                .mapToDouble(m -> m.getMonto())
                .sum();
        List<Reserva> listHotel = (ArrayList) list.stream()
                .filter(e -> (e instanceof Hotel))
                .collect(Collectors.toList());
        List<Reserva> listBoleto = (ArrayList) list.stream()
                .filter(e -> (e instanceof Boleto))
                .collect(Collectors.toList());
        if (repoClientes.containsKey(cl)){
            listLoc = repoClientes.get(cl);
        }
        else {
            listLoc = new ArrayList<>();
        }
        if(listLoc.size() != 0){

            if((listLoc.size() >= 2) || (listHotel.size() >= 2) || (listBoleto.size() >= 2)){
                //Aplico descuento de -%5
                loc.setMontoTotal(total - (total * 0.05));
                listLoc.add(loc);
                repoClientes.put(cl, listLoc);
                System.out.println("DESCUENTO 5%\n");

            }
        }
        else {
            if(completa){
                //Aplico descuento de -%10
                loc.setMontoTotal(total - (total * 0.1));
                listLoc.add(loc);
                repoClientes.put(cl, listLoc);
                System.out.println("DESCUENTO 10%\n");

            }
            else if((listHotel.size() >= 2) || (listBoleto.size() >= 2)){
                //Aplico descuento de -5%
                loc.setMontoTotal(total - (total * 0.05));
                listLoc.add(loc);
                repoClientes.put(cl, listLoc);
                System.out.println("DESCUENTO 5%\n");
            }
            else {
                loc.setMontoTotal(total);
                listLoc.add(loc);
                repoClientes.put(cl, listLoc);
            }
        }

    }
    public void mostrarCliente(Cliente cli){
        if (repoClientes.containsKey(cli)){
            List<Localizador> listLoc = repoClientes.get(cli);
            System.out.println("Datos del Paquete: \n");
            System.out.println("Nombre del cliente: " + cli.getNombre());
            System.out.println("\nTelefono: " + cli.getTelefono());
            System.out.println("\n----PAQUETE----" );
            System.out.println();
            listLoc.get(listLoc.size() - 1).getReserva()
                    .stream()
                    .forEach(e -> System.out.println(e.toString()));
            System.out.println("\nMonto total: $" + listLoc.get(listLoc.size() - 1).getMontoTotal());

        }
    }
}
