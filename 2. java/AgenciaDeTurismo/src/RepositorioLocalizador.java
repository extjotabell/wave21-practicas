import Reservas.Reserva;

import java.util.ArrayList;
import java.util.List;

public class RepositorioLocalizador {
    private List<Localizador> localizadorList;

    public void add(Cliente cli, List<Reserva> reservaList){
        double total = calcularTotal(cli, reservaList);
        localizadorList.add(new Localizador(reservaList,cli,total));
    }

    public RepositorioLocalizador() {
        this.localizadorList = new ArrayList<>();
    }

    private double calcularTotal(Cliente cli, List<Reserva> reservaList){

        return 1;
    }

    public List<Localizador> get(Cliente cliente){
        return localizadorList.stream().filter(localizador -> localizador.getCliente() == cliente).toList();
    }

    @Override
    public String toString() {
        return "RepositorioLocalizador{" +
                "localizadorList=" + localizadorList +
                "}\n";
    }
}
