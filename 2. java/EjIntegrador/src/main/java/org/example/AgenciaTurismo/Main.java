package org.example.AgenciaTurismo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------Ejercicio Agencia de Viajes----------\n");
        /*Crear un localizador con un paquete completo para un cliente, almacenar e imprimir el resultado.
Crear un localizador con 2 reservas de hotel y 2 de boletos para el mismo cliente anterior,
almacenar e imprimir el resultado.
Crear un localizador con una sola reserva para el mismo cliente.
Verificar que los descuentos fueron aplicados.
*/
        Cliente cliente1 = new Cliente("Juan Gomez", 123345);

        System.out.println("---El cliente saca un paquete completo---");
        Reserva reserva1Cliente1 = new ReservaHotel("hotel");
        Reserva reserva2Cliente1 = new ReservaComida("comida");
        Reserva reserva3Cliente1 = new ReservaTransporte("transporte");
        Reserva reserva4Cliente1 = new ReservaBoletosViaje("boletos viaje");

        List<Reserva> reservasCliente1 = new ArrayList<>();
        reservasCliente1.add(reserva1Cliente1);
        reservasCliente1.add(reserva2Cliente1);
        reservasCliente1.add(reserva3Cliente1);
        reservasCliente1.add(reserva4Cliente1);

        Localizador localizador1 = new Localizador(cliente1, reservasCliente1 );
        cliente1.getLocalizadores().add(localizador1);
        System.out.println(localizador1);


        cliente1.imprimirLocalizadores();


        System.out.println("\n---El cliente saca 2 reservas de hotel y 2 boletos---");
        Reserva reserva5Cliente1 = new ReservaHotel("hotel");
        Reserva reserva6Cliente1 = new ReservaHotel("hotel");
        Reserva reserva7Cliente1 = new ReservaBoletosViaje("boletos viaje");
        Reserva reserva8Cliente1 = new ReservaBoletosViaje("boletos viaje");
        List<Reserva> reservas2Cliente1 = new ArrayList<>();
        reservas2Cliente1.add(reserva5Cliente1);
        reservas2Cliente1.add(reserva6Cliente1);
        reservas2Cliente1.add(reserva7Cliente1);
        reservas2Cliente1.add(reserva8Cliente1);

        Localizador localizador2 = new Localizador(cliente1, reservas2Cliente1 );
        cliente1.getLocalizadores().add(localizador2);
        System.out.println(localizador2);
        cliente1.imprimirLocalizadores();

        System.out.println("\n---El cliente saca 1 reserva más---");
        Reserva reserva9Cliente1 = new ReservaHotel("hotel");
        List<Reserva> reservas3Cliente1 = new ArrayList<>();
        reservas3Cliente1.add(reserva9Cliente1);

        Localizador localizador3 = new Localizador(cliente1, reservas3Cliente1 );
        cliente1.getLocalizadores().add(localizador3);
        System.out.println(localizador3);
        cliente1.imprimirLocalizadores();
    }
}
