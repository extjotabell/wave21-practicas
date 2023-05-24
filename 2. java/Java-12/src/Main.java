import clases.Cliente;
import clases.Localizador;
import clases.Reserva;
import enums.ReservaEnum;
import repositorio.LocalizadorRepo;

import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("50648614", "Matias Tato");
        Reserva reserva1 = new Reserva(ReservaEnum.HOTEL, 1000);
        Reserva reserva2 = new Reserva(ReservaEnum.COMIDA, 200);
        Reserva reserva3 = new Reserva(ReservaEnum.TRANSPORTE, 400);
        Reserva reserva4 = new Reserva(ReservaEnum.BOLETOS_DE_VIAJE, 1500);
        Reserva reserva5 = new Reserva(ReservaEnum.TRANSPORTE, 940);

        Localizador localizador = new Localizador(cliente).addReserva(reserva1, reserva2, reserva3, reserva4);
        LocalizadorRepo.addNuevoLocalizador(cliente, localizador);
        LocalizadorRepo.addNuevoLocalizador(cliente, new Localizador(cliente).addReserva(reserva1, reserva5));
        LocalizadorRepo.addNuevoLocalizador(cliente, new Localizador(cliente).addReserva(reserva1, reserva3));



        System.out.println(LocalizadorRepo.localizadores);
    }
}