package com.bootcamp.wave21;
import java.util.List;
import java.util.ArrayList;

import java.util.Scanner;

public class Main {
/***CARRERA DE LA SELVA ****/
    public static void main(String[] args) {
    //DATOS DE LOS CIRCUITOS
    String categorias[] = {"Chico", "Mediano","Grande"};
    String descripcion[] = {"2 km por selva y arroyos", "5 Km por selva, arroyos y barro", "10 Km por selva, arroyos, barro y escalada en piedra"};
    int [][] monto_inscripcion = {{1300,1500}, {2000,2300},{-1,2800}};
    boolean habilitadas [] = {true,true,false};
    int menu = 0;
    int indiceCircuitos = 1;
    //CREO NUEVA CARRERA E INSTANCIO 3 CIRCUITOS
    Carrera carrera = new Carrera();
    List<Circuito> circuDeLaSelva = new ArrayList<Circuito>();

    carrera.setNombre("Carrera de la selva");
    for(int i = 0; i < 3; i++){
        Circuito circuito = new Circuito();
        circuito.setId(i);
        circuito.setNombre(categorias[i]);
        circuito.setMonto_menor(monto_inscripcion[i][0]);
        circuito.setMonto_mayor(monto_inscripcion[i][1]);
        circuito.setDescripcion(descripcion[i]);
        circuito.setHabilitada_menores(habilitadas[i]);
        //Agrego circuito a la carrera
        circuDeLaSelva.add(circuito);
    }
    carrera.setCircuitos(circuDeLaSelva);

    //MENU DE INSCRIPCIONES

    Scanner teclado = new Scanner(System.in);
    Scanner persona = new Scanner(System.in);

    /***EMPIEZAN LAS INSCRIPCIONES***/
    while (menu != 3 ) {
        System.out.println("------------------------------------------------------");
        System.out.println("////INSCRIPCIONES CARRERA DE LA SELVA////");
        System.out.println("------------------------------------------------------");
        System.out.println("MENU: \n 1- Cargar Participante \n 2- Ver Total de inscriptos \n 3- Salir \n >: ");

        menu = teclado.nextInt();
        switch (menu) {
            case 1:
                Inscripcion inscripcion = new Inscripcion();
                Participante participante = new Participante();
                System.out.println("Participante numero: " + carrera.getCantidadParticipantes() + 1);
                participante.setId_participante(carrera.getCantidadParticipantes() + 1);
                carrera.setCantidadParticipantes(carrera.getCantidadParticipantes() + 1);
                System.out.println("Ingrese DNI:  ");
                participante.setDni(persona.nextInt());
                persona.nextLine();
                System.out.println("Ingrese nombre: ");
                participante.setNombre(persona.nextLine());
                System.out.println("Ingrese apellido: ");
                participante.setApellido(persona.nextLine());
                System.out.println("Ingrese edad: ");
                participante.setEdad(persona.nextInt());
                if(participante.es_menor()) {
                    System.out.println("Elija Circuito:");

                    for(Circuito circuito:  carrera.getCircuitos()){
                        if(circuito.isHabilitada_menores()){
                            System.out.println(indiceCircuitos+ "-" + circuito.getNombre());
                            indiceCircuitos ++;
                        }
                    }

                }else {
                    for(Circuito circuito:  carrera.getCircuitos()){
                            System.out.println(indiceCircuitos+ "-" + circuito.getNombre());
                            indiceCircuitos ++;
                        }
                }
                System.out.println(":>");
                inscripcion.setParticipante(participante);
                inscripcion.setCircuito(carrera.getCircuitos().get(persona.nextInt() - 1));
                if(participante.es_menor()){
                    System.out.println("El monto a pagar es " + inscripcion.getCircuito().getMonto_menor());
                    inscripcion.setMonto(inscripcion.getCircuito().getMonto_menor());
                }else{
                    System.out.println("El monto a pagar es " + inscripcion.getCircuito().getMonto_mayor());
                    inscripcion.setMonto(inscripcion.getCircuito().getMonto_mayor());
                }
                System.out.println("Presione Enter para continuar");
                carrera.addInscripcion(inscripcion);
                System.out.println("Gracias por inscribirse!!! " );
                indiceCircuitos = 1 ;
                persona.reset();
                break;
            case 2:
                System.out.println("*****TOTALIZADORES ********");
                carrera.mostrar_totales();
                break;
            case 3:
                System.out.println("Hasta la proxima!! ");
                break;
        }

    }

    }
}
