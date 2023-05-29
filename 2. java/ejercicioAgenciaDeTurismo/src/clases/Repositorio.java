package clases;

import interfaces.AumentarCantidad;

public class Repositorio implements AumentarCantidad {
    private Integer cantidadReservas;
    private Integer cantidadLocalizadores;
    private Integer cantidadPaquetes;
    private Integer cantidadBoletos;

    public Repositorio(Integer cantidadReservas, Integer cantidadLocalizadores, Integer cantidadPaquetes, Integer cantidadBoletos) {
        this.cantidadReservas = cantidadReservas;
        this.cantidadLocalizadores = cantidadLocalizadores;
        this.cantidadPaquetes = cantidadPaquetes;
        this.cantidadBoletos = cantidadBoletos;
    }


    public Integer getCantidadReservas() {
        return cantidadReservas;
    }

    public void setCantidadReservas(Integer cantidadReservas) {
        this.cantidadReservas = cantidadReservas;
    }

    public Integer getCantidadLocalizadores() {
        return cantidadLocalizadores;
    }

    public void setCantidadLocalizadores(Integer cantidadLocalizadores) {
        this.cantidadLocalizadores = cantidadLocalizadores;
    }

    public Integer getCantidadPaquetes() {
        return cantidadPaquetes;
    }

    public void setCantidadPaquetes(Integer cantidadPaquetes) {
        this.cantidadPaquetes = cantidadPaquetes;
    }

    public Integer getCantidadBoletos() {
        return cantidadBoletos;
    }

    public void setCantidadBoletos(Integer cantidadBoletos) {
        this.cantidadBoletos = cantidadBoletos;
    }

    @Override
    public void aumentarCantidadReservas() {
        this.cantidadReservas += 1;
    }

    @Override
    public void aumentarCantidadLocalizadores() {
        this.cantidadLocalizadores += 1;
    }

    @Override
    public void aumentarCantidadPaquetes() {
        this.cantidadLocalizadores += 1;
    }

    @Override
    public void aumentarCantidadBoletos() {
        this.cantidadBoletos += 1;
    }

    @Override
    public String toString() {
        return "Repositorio{" +
                "cantidadReservas=" + cantidadReservas +
                ", cantidadLocalizadores=" + cantidadLocalizadores +
                ", cantidadPaquetes=" + cantidadPaquetes +
                ", cantidadBoletos=" + cantidadBoletos +
                '}';
    }
}
