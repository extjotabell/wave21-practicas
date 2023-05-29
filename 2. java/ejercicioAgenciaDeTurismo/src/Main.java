import clases.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Cliente cliente= new Cliente("Juan","Lopez","3434343",new Repositorio(0,0,0,0));
        ReservaHotel reservaHotel= new ReservaHotel("Empire State","Florida(?",43434d);
        Localizador paqueteCompleto= new Localizador(cliente, Arrays.asList(reservaHotel),Arrays.asList(new Boleto("13213",444d)),Arrays.asList(new Comida("Hamburguesa",23d)));

        System.out.println(paqueteCompleto.toString());

        Localizador localizador2Reservas= new Localizador(cliente, Arrays.asList(reservaHotel,reservaHotel));
        System.out.println(localizador2Reservas.toString());

        Localizador localizador1Reserva =new Localizador(cliente,Arrays.asList(reservaHotel));
        System.out.println(localizador1Reserva.toString());
    }
}