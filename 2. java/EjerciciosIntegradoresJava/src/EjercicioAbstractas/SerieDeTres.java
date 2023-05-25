package EjercicioAbstractas;

import EjercicioAbstractas.Prototipo;

public class SerieDeTres extends Prototipo {
    @Override
    public Integer valorSiguiente() {

        setValorActual(getValorInicial() +3);
        return getValorActual();
    }

}
