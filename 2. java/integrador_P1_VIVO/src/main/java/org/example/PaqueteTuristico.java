package org.example;

public class PaqueteTuristico {

    int hotel;
    int comida;
    int boletosDeViajes;
    int transporte;

    public PaqueteTuristico(int hotel, int comida, int boletosDeViajes, int transporte) {
        this.hotel = hotel;
        this.comida = comida;
        this.boletosDeViajes = boletosDeViajes;
        this.transporte = transporte;
    }

    public int getHotel() {
        return hotel;
    }

    public void setHotel(int hotel) {
        this.hotel = hotel;
    }

    public int getComida() {
        return comida;
    }

    public void setComida(int comida) {
        this.comida = comida;
    }

    public int getBoletosDeViajes() {
        return boletosDeViajes;
    }

    public void setBoletosDeViajes(int boletosDeViajes) {
        this.boletosDeViajes = boletosDeViajes;
    }

    public int getTransporte() {
        return transporte;
    }

    public void setTransporte(int transporte) {
        this.transporte = transporte;
    }

    @Override
    public String toString() {
        return "PaqueteTuristico{" +
                "hotel='" + hotel + '\'' +
                ", comida='" + comida + '\'' +
                ", boletosDeViajes='" + boletosDeViajes + '\'' +
                ", transporte='" + transporte + '\'' +
                '}';
    }
}
