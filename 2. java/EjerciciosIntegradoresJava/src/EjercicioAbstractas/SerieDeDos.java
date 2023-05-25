package EjercicioAbstractas;

import EjercicioAbstractas.Prototipo;

import java.util.ArrayList;
import java.util.List;

public class SerieDeDos extends Prototipo {
    @Override
    public Integer valorSiguiente() {
        setValorActual(getValorInicial() +2);
        return getValorActual();
    }

}
