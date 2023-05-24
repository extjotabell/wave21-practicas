import Reservas.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RepositorioLocalizador {
    private List<Localizador> localizadorList;

    public void add(Cliente cli, List<Reserva> reservaList){
        double total = this.calcularTotal(cli, reservaList);
        localizadorList.add(new Localizador(reservaList,cli,total));
    }

    public RepositorioLocalizador() {
        this.localizadorList = new ArrayList<>();
    }

    private double calcularTotal(Cliente cli, List<Reserva> reservaList){
        double total = 0;
        //calculo el total base
        total = reservaList.stream().mapToDouble(Reserva::getMonto).sum();

        // descuento para mas de 2 localizadores anteriores 5% de descuento
        if(get(cli).size()>=2)
            total *= 0.95;

        //si tiene paquete completo 10% de descuento
        if(reservaList.stream().anyMatch(reserva -> Objects.equals(reserva.getClass(), ReservaComida.class)) &&
                reservaList.stream().anyMatch(reserva -> Objects.equals(reserva.getClass(), ReservaHotel.class)) &&
                reservaList.stream().anyMatch(reserva -> Objects.equals(reserva.getClass(), ReservaBoletoTransporte.class)) &&
                reservaList.stream().anyMatch(reserva -> Objects.equals(reserva.getClass(), ReservaBoletoViaje.class)))
        {
            total*= 0.9;
        }
        //si tiene 2 reservas de hotel o dos reserva de boleto de viaje 5% de descuento
        if(reservaList.stream().filter(reserva -> Objects.equals(reserva.getClass(), ReservaHotel.class)).count() > 1 ||
                reservaList.stream().filter(reserva -> Objects.equals(reserva.getClass(), ReservaBoletoViaje.class)).count() > 1)
        {
            total*= 0.95;
        }

        return total;
    }

    public List<Localizador> get(Cliente cliente){
        return localizadorList.stream().filter(localizador -> localizador.getCliente() == cliente).toList();
    }
    public List<Localizador> get(){
        return localizadorList;
    }


    @Override
    public String toString() {
        return "RepositorioLocalizador{" +
                "localizadorList=" + localizadorList +
                "}\n";
    }
}
