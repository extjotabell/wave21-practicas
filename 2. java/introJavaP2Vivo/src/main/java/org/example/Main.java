package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        // Crear 3 objetos de tipo categoría (uno por cada categoría) con sus respectivos datos
        HashMap<Integer,String[]> categorias = new HashMap<>();
        String[] circuitoChico = new String[]{"Circuito chico","2 km por selva y arroyos"};
        categorias.put(1, circuitoChico);
        String[] circuitoMedio = new String[]{"Circuito medio","5 km por selva, arroyos y barro"};
        categorias.put(2, circuitoChico);
        String[] circuitoAvanzado = new String[]{"Circuito avanzado","10 km por selva, arroyos, barro y escalada en piedra"};
        categorias.put(3, circuitoChico);

        // Inscripciones
        //
        // Num Inscripcion / NumCategoria / NumParticipante / Monto
        ArrayList<String[]> inscripciones = new ArrayList<>();


        // Participantes
        //
        // NumParticipante / DNI / Nombre /Apellido / Edad / Celular / NumEmergencia / GrupoSanguineo
        ArrayList<Object[]> participantes = new ArrayList<>();

        participantes.add(new Object[]{1, 12345678, "John", "Doe", 10, 1234, 12345, "B"});
        participantes.add(new Object[]{1, 12345678, "John", "Doe", 10, 1234, 12345, "B"});
        participantes.add(new Object[]{1, 12345678, "John", "Doe", 10, 1234, 12345, "B"});
        participantes.add(new Object[]{1, 12345678, "John", "Doe", 10, 1234, 12345, "B"});

        //Float.parseFloat(num);


    }
}