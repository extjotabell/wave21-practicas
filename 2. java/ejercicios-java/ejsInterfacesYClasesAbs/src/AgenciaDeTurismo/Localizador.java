package AgenciaDeTurismo;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private List<Reserva> reservas;
    private Cliente cliente;
    private double total;

    public void aplicarDescuento(){
        long cantReservasHotel = reservas.stream()
                .filter(x -> x instanceof ReservaHotel)
                .count();

        long cantReservasViaje = reservas.stream()
                .filter(x -> x instanceof ReservaBoletosDeViaje)
                .count();

        long cantReservasComida = reservas.stream()
                .filter(x -> x instanceof ReservaComida)
                .count();

        long cantReservasTransporte = reservas.stream()
                .filter(x -> x instanceof ReservaTransporte)
                .count();

        //Si un cliente tiene 2 ReservaHotel o ReservaViaje, se reduce un 5% a dichas reservas
        if(cantReservasHotel >= 2 || cantReservasViaje >= 2){
            reservas
                    .forEach(
                            x -> {
                                if(x instanceof ReservaHotel || x instanceof ReservaBoletosDeViaje){
                                    x.setMonto(x.getMonto()*0.95);
                                }
                            }

                    );
        }

        if(cantReservasHotel >= 1 && cantReservasViaje >= 1 && cantReservasTransporte >= 1 && cantReservasComida >=1 ){
            setTotal(this.getTotal()*0.90);
        }
    }

    public void total(){
        setTotal( reservas.stream()
                .mapToDouble(Reserva::getMonto)
                .sum()
        );
    }

    public void agregarReserva(Reserva reserva){
        this.reservas.add(reserva);
    }

    public Localizador(Cliente cliente) {
        this.reservas = new ArrayList<Reserva>();
        this.cliente = cliente;
        this.total = 0;
    }

    public Localizador() {
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "reservas=" + reservas +
                ", cliente=" + cliente +
                ", total=" + total +
                '}';
    }
}
