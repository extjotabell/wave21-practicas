package org.example.logic;

import org.example.model.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Repositorio {
    private Map<Cliente, List<Localizador>> repositorioClientes;

    private Double descuento;

    public Repositorio(){
        repositorioClientes= new LinkedHashMap<Cliente, List<Localizador>>();
        descuento=0d;
    }


    public void agregarLocalizador(Localizador localizador){

        Cliente cliente = localizador.getCliente();
        List<Localizador> listaLocalizadores = new ArrayList<Localizador>();
        if(repositorioClientes.containsKey(cliente)){
            listaLocalizadores = repositorioClientes.get(cliente);
        }
        listaLocalizadores.add(localizador);
        repositorioClientes.put(cliente,listaLocalizadores);

    }
    public void mostrarLocalizadoresPorCliente(Cliente cliente) {
        System.out.println("\nLISTA DE LOCALIZADORES DEL CLIENTE "+cliente.getId());
        this.repositorioClientes.forEach((clienteLista, listaLocalizadores) -> {
                    if (clienteLista == cliente) {
                        listaLocalizadores.forEach(Localizador::imprimirLocalizador);
                    }
                }
        );
    }

    public void mostrarLocalizadores() {
        System.out.println("\nLISTA DE TODOS LOS LOCALIZADORES");
        this.repositorioClientes.forEach((clienteLista, listaLocalizadores) ->
                listaLocalizadores.forEach(Localizador::imprimirLocalizador)
        );
    }

    public void mostrarDescuentos(Cliente cliente){
        this.mostrarProximoDescuentoPorCliente(cliente);
        this.mostrarDescuentoTotalPorCliente(cliente);
        this.mostrarDescuentoPorHotelyBoletos(cliente);
    }
    public void mostrarProximoDescuentoPorCliente(Cliente cliente){

        Integer cantidad = 0;
        try {
            cantidad = repositorioClientes.get(cliente).size();
        }
        catch(Exception e){}
        System.out.println("Descuento en la próxima compra por tener más de dos localizadores = "+(cantidad>=2?"5%":"0%"));

    }

    public void mostrarDescuentoTotalPorCliente(Cliente cliente){

        List<Localizador> localizadores;
        AtomicReference<Boolean> paqueteCompleto = new AtomicReference<>(false);
        AtomicInteger contador= new AtomicInteger();
        localizadores =  repositorioClientes.get(cliente);
        localizadores.forEach(l->{
            List<Reserva> reservas= l.getReserva();
            reservas.forEach(r->{
                if(r instanceof Hotel) contador.addAndGet(100);
                else if (r instanceof Comida) contador.addAndGet(200);
                else if(r instanceof Boletos) contador.addAndGet(400);
                else if(r instanceof Transporte) contador.addAndGet(800);
            });
            if(contador.get()==1500) paqueteCompleto.set(true);
        });
        System.out.println("Descuento en la próxima compra por tener paquete completo = "+(paqueteCompleto.get()?"10% en la factura":"0%"));

    }

    public void mostrarDescuentoPorHotelyBoletos(Cliente cliente){
        List<Localizador> localizadores;
        AtomicReference<Boolean> descuentoHotelyBoletos = new AtomicReference<>(false);
        AtomicInteger contador= new AtomicInteger();
        localizadores =  repositorioClientes.get(cliente);
        localizadores.forEach(l->{
            List<Reserva> reservas= l.getReserva();
            reservas.forEach(r->{
                if(r instanceof Hotel) contador.addAndGet(100);
                else if(r instanceof Boletos) contador.addAndGet(400);
            });
            if(contador.get()==1000) descuentoHotelyBoletos.set(true);
        });
        System.out.println("Descuento en la próxima compra por tener reserva de hotel y de boletos = "+(descuentoHotelyBoletos.get()?"10% en la factura":"0%"));

    }

    public void cantidadLocalizadoresVendidos(){
        AtomicInteger cantidad = new AtomicInteger();
        List<Localizador> localizadores;
        repositorioClientes.values().stream().forEach(
                l->{
                    cantidad.addAndGet(l.size());
                }
        );
        System.out.println(cantidad);
    }

    public void cantidadReservas(){
        List<Localizador> localizadores;
        AtomicReference<Boolean> descuentoHotelyBoletos = new AtomicReference<>(false);
        AtomicInteger contador= new AtomicInteger();
        repositorioClientes.values().stream().forEach(lista->lista.stream().forEach(l->{
            List<Reserva> reservas= l.getReserva();
            contador.addAndGet(reservas.size());
        }));
        System.out.println(contador);
    }

    public void mostrarDiccionarioReservas(){
        Map<String,Integer> reservasDicc = new HashMap<String,Integer>();
        repositorioClientes.values().stream().forEach(lista->lista.stream().forEach(l->{
            List<Reserva> reservas= l.getReserva();
            reservas.forEach(r->{
                if(reservasDicc.containsKey(r.getNombre())){
                    reservasDicc.put(r.getNombre(),reservasDicc.get(r.getNombre())+1);
                }
                else{
                    reservasDicc.put(r.getNombre(),1);
                }
            });
        }));
        System.out.println(reservasDicc.toString());
    }

    public void mostrarTotalDeVentas(){

        AtomicReference<Double> totalVentas= new AtomicReference<>(0d);
        repositorioClientes.values().stream().forEach(lista->lista.stream().forEach(l-> {
            totalVentas.updateAndGet(v -> v + l.getTotal());
        }));
        System.out.println(totalVentas);

    }

    public void mostrarPromedioDeVentas(){

        AtomicReference<Double> totalVentas= new AtomicReference<>(0d);
        AtomicReference<Double> cantidad = new AtomicReference<>(0d);
        repositorioClientes.values().stream().forEach(lista->lista.stream().forEach(l-> {
            totalVentas.updateAndGet(v -> v + l.getTotal());
            cantidad.getAndSet(cantidad.get() + 1);
        }));
        System.out.println(totalVentas.get()/ cantidad.get());

    }

    public Map<Cliente, List<Localizador>> getRepositorioClientes() {
        return repositorioClientes;
    }

    public void setRepositorioClientes(Map<Cliente, List<Localizador>> repositorioClientes) {
        this.repositorioClientes = repositorioClientes;
    }
}
