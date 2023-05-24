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
        double monto = 0;
        //calculo el monto base
        monto = reservaList.stream().mapToDouble(Reserva::getMonto).sum();

        // descuento para mas de 2 localizadores anteriores
        if(get(cli).size()>=2)
            monto *= 0.95;

        //si tiene paquete completo
        if(reservaList.stream().anyMatch(reserva -> Objects.equals(reserva.getClass(), ReservaComida.class)) &&
                reservaList.stream().anyMatch(reserva -> Objects.equals(reserva.getClass(), ReservaHotel.class)) &&
                reservaList.stream().anyMatch(reserva -> Objects.equals(reserva.getClass(), ReservaBoletoTransporte.class)) &&
                reservaList.stream().anyMatch(reserva -> Objects.equals(reserva.getClass(), ReservaBoletoViaje.class)))
        {
            monto*= 0.9;
        }
        //si tiene 2 reservas de hotel o dos reserva de boleto de viaje
        if(reservaList.stream().filter(reserva -> Objects.equals(reserva.getClass(), ReservaHotel.class)).count() > 1 ||
                reservaList.stream().filter(reserva -> Objects.equals(reserva.getClass(), ReservaBoletoViaje.class)).count() > 1)
        {
            monto*= 0.95;
        }


        return monto;
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
