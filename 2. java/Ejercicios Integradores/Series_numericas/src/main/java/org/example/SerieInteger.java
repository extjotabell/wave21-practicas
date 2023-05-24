package org.example;


import java.util.List;

public class SerieInteger extends Prototipo<Integer>{
    public SerieInteger(Integer valorSemilla, Integer valorPaso) {
        super(valorSemilla, valorPaso);
    }

    @Override
    public void valorSiguiente() {
        Integer ultimo = sucesion.get(sucesion.size()-1);
        Integer siguiente  = ultimo + valorPaso;
        sucesion.add(siguiente);
        System.out.println(siguiente);
    }
}
