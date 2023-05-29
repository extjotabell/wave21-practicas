package clases;

import java.util.List;
import java.util.stream.Collectors;

public class Localizador {
    private Cliente cliente;
    private Double total;
    private List<ReservaHotel> reservas;
    private List<Boleto> boletos;
    private List<Comida> comidas;

    public Localizador(Cliente cliente, List<ReservaHotel> reservas, List<Boleto> boletos, List<Comida> comidas) {
        this.cliente = cliente;
        if(boletos.size()>=2)
            boletos.forEach(boleto -> {
                boleto.setTotal(boleto.getTotal()-(boleto.getTotal()*0.05));
                this.cliente.getRepositorio().aumentarCantidadBoletos();
            });
        if(reservas.size()>=2)
            reservas.forEach(reservaHotel -> {
                reservaHotel.setTotal(reservaHotel.getTotal()-(reservaHotel.getTotal()*0.05));
                this.cliente.getRepositorio().aumentarCantidadReservas();
            });
        this.reservas = reservas;
        this.boletos = boletos;
        this.comidas = comidas;
        this.total=getTotal(reservas,boletos,comidas);
        if(this.cliente.getRepositorio().getCantidadLocalizadores()>=2)
            this.total-=(this.total*0.05);
        if(reservas!=null && boletos!=null &&  comidas!=null)
            this.total-=(this.total*0.1);
        reservas.forEach(reservaHotel -> this.cliente.getRepositorio().aumentarCantidadReservas());
        boletos.forEach(boleto -> this.cliente.getRepositorio().aumentarCantidadBoletos());
        this.cliente.getRepositorio().aumentarCantidadLocalizadores();
    }

    public Localizador(Cliente cliente, List<ReservaHotel> reservas,List<Boleto> boletos) {
        this.cliente = cliente;
        if(reservas.size()>=2)
            reservas.forEach(reservaHotel -> {
                reservaHotel.setTotal(reservaHotel.getTotal()-(reservaHotel.getTotal()*0.05));
                this.cliente.getRepositorio().aumentarCantidadReservas();
            });
        this.reservas = reservas;
        if(boletos.size()>=2)
            boletos.forEach(boleto -> {
                boleto.setTotal(boleto.getTotal()-(boleto.getTotal()*0.05));
                this.cliente.getRepositorio().aumentarCantidadBoletos();
            });
        this.boletos=boletos;
        this.total=getTotal(reservas,boletos);
        if(this.cliente.getRepositorio().getCantidadLocalizadores()>=2)
            this.total-=(this.total*0.05);
        this.cliente.getRepositorio().aumentarCantidadLocalizadores();
    }

    public Localizador(Cliente cliente, List<ReservaHotel> reservas) {
        this.cliente = cliente;
        if(reservas.size()>=2)
            reservas.forEach(reservaHotel -> reservaHotel.setTotal(reservaHotel.getTotal()-(reservaHotel.getTotal()*0.05)));
        this.reservas = reservas;
        this.total=getTotal(reservas);
        if(this.cliente.getRepositorio().getCantidadLocalizadores()>=2)
            this.total-=(this.total*0.05);
        this.cliente.getRepositorio().aumentarCantidadLocalizadores();
        reservas.forEach(reservaHotel -> this.cliente.getRepositorio().aumentarCantidadReservas());
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getTotal(List<ReservaHotel> reservas,List<Boleto> boletos,List<Comida> comidas) {
        return reservas.stream().map(reservaHotel -> reservaHotel.getTotal()).reduce((r1,r2)->r1+r2).orElse(0d)
                +boletos.stream().map(boleto -> boleto.getTotal()).reduce((b1,b2)->b1+b2).orElse(0d)
                +comidas.stream().map(comida -> comida.getTotal()).reduce((c1,c2)->c1+c2).orElse(0d);
    }

    public Double getTotal(List<ReservaHotel> reservas) {
        return reservas.stream().map(reservaHotel -> reservaHotel.getTotal()).reduce((r1,r2)->r1+r2).orElse(0d);
    }

    public Double getTotal(List<ReservaHotel> reservas,List<Boleto> boletos) {
        return reservas.stream().map(reservaHotel -> reservaHotel.getTotal()).reduce((r1,r2)->r1+r2).orElse(0d)
                +boletos.stream().map(boleto -> boleto.getTotal()).reduce((b1,b2)->b1+b2).orElse(0d);
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<ReservaHotel> getReservas() {
        return reservas;
    }

    public void setReservas(List<ReservaHotel> reservas) {
        this.reservas = reservas;
    }

    public List<Boleto> getBoletos() {
        return boletos;
    }

    public void setBoletos(List<Boleto> boletos) {
        this.boletos = boletos;
    }

    public List<Comida> getComidas() {
        return comidas;
    }

    public void setComidas(List<Comida> comidas) {
        this.comidas = comidas;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", total=" + total +
                ", reservas=" + reservas +
                ", boletos=" + boletos +
                ", comidas=" + comidas +
                '}';
    }
}
