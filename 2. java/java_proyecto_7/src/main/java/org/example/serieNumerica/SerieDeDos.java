package org.example.serieNumerica;

public class SerieDeDos extends Prototipo<Integer>{
    private static Integer serie = 2;

    public SerieDeDos(Integer inicio) {
        super(inicio, serie);
    }

    @Override
    public Integer valorSiguiente() {
        valorActual = valorActual + salto;
        return valorActual;
    }


}
