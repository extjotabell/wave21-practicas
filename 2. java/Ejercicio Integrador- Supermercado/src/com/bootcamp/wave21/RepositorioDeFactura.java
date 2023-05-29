package com.bootcamp.wave21;

import com.bootcamp.wave21.model.Cliente;
import com.bootcamp.wave21.model.Factura;
import com.bootcamp.wave21.model.ItemFactura;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RepositorioDeFactura implements Repositorio {

private List<Factura> facturas ;
private RepositorioDeCliente gestorCliente;

public RepositorioDeFactura(RepositorioDeCliente ges){
    facturas = new ArrayList<>();
    this.gestorCliente = ges;
}



    public void menuGestorFactura(){
        Scanner ingresoTeclado = new Scanner(System.in);
        int menu = 0;
        String docu;
        Cliente resultado;
        ItemFactura producto;
        Factura factura;

        while(menu != 4){
            System.out.println("\n\n\n\n*******BIENVENIDOS AL GESTOR DE FACTURAS********\n\n\n");
            System.out.println("1.- Nueva Factura\n2.- Eliminar Factura\n3.- Imprimir \n 4.- Salir>:");
            menu = ingresoTeclado.nextInt();
            ingresoTeclado.nextLine();

            switch (menu){
                case 1 :
                    System.out.println("Ingrese DNI DEl cliente: ");
                    docu = ingresoTeclado.nextLine();
                    resultado = gestorCliente.buscar(docu);
                    if(resultado == null){
                        System.out.println("Ese cliente no se encuentra registrado en la BBDD");
                        System.out.println("Se deriva al menu de clientes para su creacion");
                        gestorCliente.menuGestorCliente();
                    }else{

                        factura = new Factura();
                        factura.setCliente(resultado);
                        int temp ;
                        System.out.println("****AGREGAR PRODUCTOS******");
                        System.out.println("****PRESIONE 0 PARA SALIR*****");
                        while(!ingresoTeclado.hasNextInt())
                            ingresoTeclado.next();
                        temp = ingresoTeclado.nextInt();
                        ingresoTeclado.nextLine();
                        while(temp != 0) {
                            producto = new ItemFactura();
                            System.out.println("INGRESE EL NOMBRE DEL PRODUCTO");
                            producto.setNombre(ingresoTeclado.nextLine());
                            producto.setCodigo("1234");
                            System.out.println("INGRESE LA CANTIDAD ");
                            producto.setCantComprada(ingresoTeclado.nextInt());
                            ingresoTeclado.nextLine();
                            producto.setCostoUnitario(23.5);
                            factura.agregarProducto(producto);
                            System.out.println("****PRESIONE 0 PARA SALIR*****");
                            temp = ingresoTeclado.nextInt();
                            ingresoTeclado.nextLine();
                        }
                        System.out.println("****RESUMEN DE FACTURA*****");
                        factura.mostrarProductos();
                        factura.calcularCosto();
                        System.out.println("COSTO TOTAL: "+ factura.getCostoTotal());
                        facturas.add(factura);


                    }
                    break;
                case 2 :


                    break;
                case 3 :
                    this.facturas.forEach(System.out::println);
                    break;
                case 0 :


            }


        }
        System.out.println("\n\n\n\n*******MUCHAS GRACIAS*******\n\n\n");

    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public RepositorioDeCliente getGestorCliente() {
        return gestorCliente;
    }

    public void setGestorCliente(RepositorioDeCliente gestorCliente) {
        this.gestorCliente = gestorCliente;
    }

    @Override
    public Factura buscar(Object obj) {
        Factura fact = (Factura) obj;
        for(Factura factura : facturas){
            if(fact.equals(factura)){
                return fact;
            }
        }
        return null;
    }

    @Override
    public boolean agregar(Object obj) {
        Factura fact = (Factura) obj;
        facturas.add(fact);
        return true;
    }

    @Override
    public boolean eliminar(Object obj) {
    Factura fac = (Factura) obj;
    if(buscar(fac) == null){
        return false;
    }
    this.getFacturas().remove(fac);
        return true;
    }

    @Override
    public List<Factura> buscarTodos() {

        return this.getFacturas().stream().collect(Collectors.toList());
    }
}
