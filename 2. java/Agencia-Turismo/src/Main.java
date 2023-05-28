import clases.*;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Repositorio repoPrueba = new Repositorio();
        Cliente cl1 = new Cliente(1, "Demian", "2656-909009");
        Cliente cl2 = new Cliente(2, "Raul", "2665-224466");
        Cliente cl3 = new Cliente(3, "Laura", "2665-232222");

        List<Reserva> rsCompleta = new ArrayList<>();
        rsCompleta.add(new Hotel(9000, "Hotel estrella marina"));
        rsCompleta.add(new Comida(450, "Restautant 2.0"));
        rsCompleta.add(new Boleto(850, "Brasil"));
        rsCompleta.add(new Transporte(900));

        repoPrueba.cargarLocalizadorACliente(cl1, rsCompleta, true);
        repoPrueba.mostrarCliente(cl1);

        System.out.println("--------------\n");
        List<Reserva> rs= new ArrayList<>();
        rs.add(new Hotel(9000, "Hotel estrella marina"));
        rs.add(new Hotel(450, "Hotel 2.0"));
        rs.add(new Boleto(850, "Brasil"));
        rs.add(new Boleto(550,"Argentina"));

        repoPrueba.cargarLocalizadorACliente(cl2, rs, false);
        repoPrueba.mostrarCliente(cl2);
        System.out.println("--------------\n");

        List<Reserva> rs2 = new ArrayList<>();
        rs2.add(new Hotel(5600, "Hotel estrella del rio 4.0"));

        repoPrueba.cargarLocalizadorACliente(cl3, rs2, false);
        repoPrueba.mostrarCliente(cl3);
    }
}